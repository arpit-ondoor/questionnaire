import { Injectable } from '@angular/core';
import { Http, Response} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {Observer} from 'rxjs/Observer';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import {IQuestionnaire} from '../interfaces';
import {IInputTypes} from '../interfaces';

import { ConfigService } from '../utils/config.service';

@Injectable()
export class DataService {

    _baseUrl: string = '';
    constructor(public http: Http,
        private configService: ConfigService) {
        this._baseUrl = configService.getApiURI();
    }

    /****** Create Questionnaire *****/
	createQuestionnaire(questionnaire : IQuestionnaire) {
        
        return this.http.post(this._baseUrl + 'questions/create', questionnaire)
            .map((res: Response) => {
                    return this.extractJsonData(res.json());
        });
    }
    /****** Create Questionnaire *****/

    /****** Get All Question Input Types *****/
    getInputTypes() : Observable<IInputTypes[]>
    {
        return this.http.get(this._baseUrl+ 'inputtypes/getall')
        .map((res:Response) => {
            return this.extractJsonData(res.json());
        })
        .catch(this.handleError);
    }
    /****** Get All Question Input Types *****/

    private handleError(error: any) {
        var applicationError = error.headers.get('Application-Error');
        var serverError = error.json();
        var modelStateErrors: string = '';

        if (!serverError.type) {
            console.log(serverError);
            for (var key in serverError) {
                if (serverError[key])
                    modelStateErrors += serverError[key] + '\n';
            }
        }

        modelStateErrors = modelStateErrors = '' ? null : modelStateErrors;
        return Observable.throw(applicationError || modelStateErrors || 'Server error');
    }

   public extractJsonData(json) {
        if(json!=null) {
           
                if(json.status && json.status==1) {
         
                if(json.message) {
                    alert(json.message);
                }

                if(json.data!=null)
                return json.data;
            }
            else   if(json.status!=null && json.status==0) {
                    if(json.message) {
                    alert(json.message);
                    throw json.message;
                 }
                 if(json.errors) {
                     var errorS="";
                     alert("Invalid Field Data");
                    throw "Invalid Field Data";
                    //  json.errors.fieldErrors.array.forEach(element => {
                    //      errorS=
                    //  });
                 }
            }
        }
        return null;
    }
}
