import { Component, Input } from '@angular/core';
import { FormGroup, FormArray, FormControl, Validators } from '@angular/forms';
import { QuestionControlService }    from './question-control.service';

@Component({
    moduleId: module.id,
    selector: 'option-choice',
    templateUrl: 'option.component.html',
    providers: [ QuestionControlService ]
})
export class OptionComponent {
    @Input('group')
    public optionForm: FormGroup;
    @Input('type')
    public type: string;
    @Input('options')
    public options: any;
    @Input('isChild')
    public isChild: boolean;
    hasChild: boolean=false;

  constructor(private qcs: QuestionControlService) {  }
    
   initQuestion() {
      let data = this.qcs.getFormBuilder().group({
              name: ['', [Validators.required]],
          })

     let options=this.qcs.getFormBuilder().array([]);
     options.push(data);
        return this.qcs.getFormBuilder().group({
            name: ['', Validators.required],
            isChild:[true],
            type:[this.options[0].key],
            typeId:[this.options[0].id],
            options:options
        });
    }

    addSubQuestion(){
        if(!this.optionForm.controls['questions']){
            this.optionForm.addControl("questions", this.qcs.getFormBuilder().array([]));
        }
        
      this.hasChild=true;
      const control = <FormArray>this.optionForm.controls['questions'];
      const addrCtrl = this.initQuestion();
      
      control.push(addrCtrl);
    }
}