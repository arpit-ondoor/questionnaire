import { Component, Input, OnInit }  from '@angular/core';
import { QuestionControlService }    from './question-control.service';
import { FormGroup, FormArray, FormControl, Validators } from '@angular/forms';
import {Router,ActivatedRoute} from '@angular/router';
import { DataService } from '../shared/services/data.service';
import { IInputTypes } from '../shared/interfaces';

@Component({
  moduleId: module.id,
  selector: 'dynamic-form',
  templateUrl: './dynamic-form.component.html',
  providers: [ QuestionControlService ]
})
export class DynamicFormComponent implements OnInit {
  
  form: FormGroup;
  payLoad = '';
  inputtypes:any;
  isFormNonEmpty:boolean=false;


  constructor(private dataService: DataService, private service: QuestionControlService,  private router:Router) {  }
  ngOnInit() {
     this.initInputType();
     this.form =  this.service.getNewFormGroup();

     this.addOptions();
  }


  onSubmit() {
    this.payLoad = JSON.stringify(this.form.value);

    this.dataService.createQuestionnaire(this.form.value)
      .subscribe(
          data => {
                  this.router.navigate(['/']);
          },
          error => {
            console.log("error:"+error);
      });
  }

   initQuestion() {
      let data = this.service.getFormBuilder().group({
            name: ['', [Validators.required]],
        })

     let options=this.service.getFormBuilder().array([]);
     options.push(data);
        return this.service.getFormBuilder().group({
            name: ['', Validators.required],
            isChild: [false],
            type:[this.inputtypes[0].key],
            typeId:[this.inputtypes[0].id],
            options:options
        });
    }

    addNewQuestion() {
      this.isFormNonEmpty=true;
      const control = <FormArray>this.form.controls['questions'];
      const addrCtrl = this.initQuestion();
      control.push(addrCtrl);
  }

    addOptions() {
     this.form.addControl("questions", this.service.getFormBuilder().array([]));
    }

    initInputType() {
    let inputtype:any={};
        this.dataService.getInputTypes()
            .subscribe((types: IInputTypes[]) => {
              this.inputtypes=[];
                types.forEach(val=>{
                  inputtype={};
                  inputtype.id=val.id;
                  inputtype.key=val.inputTypeName;
                  inputtype.value=val.displayValue
                  this.inputtypes.push(inputtype);
                });
            },
            error => {
            console.log('Failed to load Units. ' + error);
                //this.notificationService.printErrorMessage('Failed to load Units. ' + error);
            });

      // return [
      //     {key: 'multilinetext',  value: 'Multi-line text',id:1},
      //     {key: 'singlechoice',  value: 'Single choice',id:2},
      //     {key: 'multiplechoice',   value: 'Multiple choice',id:3},
      //   ];
    }
}