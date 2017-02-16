import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
    moduleId: module.id,
    selector: 'questions',
    templateUrl: 'questions.component.html',
})
export class QuestionsComponent {
    @Input('group')
    public form: FormGroup;
    @Input('options')
    public options: any;
}