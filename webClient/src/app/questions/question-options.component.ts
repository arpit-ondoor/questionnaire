import { Component, Input } from '@angular/core';
import { FormGroup, FormArray, FormControl, Validators } from '@angular/forms';
import { QuestionControlService }    from './question-control.service';

@Component({
    moduleId: module.id,
    selector: 'question-options',
    templateUrl: 'question-options.component.html',
    providers: [ QuestionControlService ]
})
export class QuestionOptionsComponent {
    @Input('group')
    public questionForm: FormGroup;
    @Input('options')
    public options: any;

    constructor(private qcs: QuestionControlService) {  }

    getNewOptionObject() {
            return this.qcs.getFormBuilder().group(
                {name: ['', [Validators.required]],},
            );
    }
    onChange(event){
        let val=event.val[0];
        let optionData=[];
        this.questionForm.controls['type'].setValue(val);
        this.questionForm.controls['typeId'].setValue(event.val[1]);
        this.questionForm.removeControl("options");
        if(val=="multilinetext") {
            optionData.push(this.getNewOptionObject());
        }
        else if(val=="singlechoice") {
            for(let i=0;i<3;i++){
            optionData.push(this.getNewOptionObject());
            }
        }
        else if(val=="multiplechoice") {
            for(let i=0;i<5;i++){
                optionData.push(this.getNewOptionObject());
            }
        }
        this.questionForm.addControl("options", this.qcs.getFormBuilder().array(optionData));
    }
}