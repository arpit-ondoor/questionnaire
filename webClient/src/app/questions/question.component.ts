import { Component }       from '@angular/core';
@Component({
  selector: 'question',
  template: `
    <div style="margin-left: 20px; margin-right: 20px;">
      <h4>Questionnaire</h4>
      <dynamic-form></dynamic-form>
    </div>
  `,
})
export class QuestionComponent {
  constructor() {
  }
}