import { Injectable }   from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Injectable()
export class QuestionControlService {
  constructor(private _fb: FormBuilder) { }

  getFormBuilder() {
    return this._fb;
  }

  getNewFormGroup() {
       return this._fb.group({});
  }
}