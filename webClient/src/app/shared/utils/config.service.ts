import { Injectable } from '@angular/core';

@Injectable()
export class ConfigService {
    
    _apiURI : string;

    constructor() {
         this._apiURI = 'http://localhost:8081/questionnaire/';
        //this._apiURI = 'http://192.168.10.162:8081/ondoortotal/';
        
     }

     getApiURI() {
         return this._apiURI;
     }

     getApiHost() {
         return this._apiURI.replace('api/','');
     }
}
