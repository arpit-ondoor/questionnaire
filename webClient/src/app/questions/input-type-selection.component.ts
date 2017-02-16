import { Component, EventEmitter, Input, Output } from '@angular/core';
@Component({
  moduleId: module.id,
  selector: 'df-question-its',
  templateUrl: './input-type-selection.component.html'
})
export class InputTypeSelectionComponent {
  @Input() options: any;
  @Output() public onChange:EventEmitter<any> = new EventEmitter();

  public change(option:any):void {
      let val=option.value.split(",");
      this.onChange.emit({val});
  }
}