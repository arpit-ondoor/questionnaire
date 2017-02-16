import { Component, ViewEncapsulation } from '@angular/core';

@Component({
    selector: 'spring-boot-angular2',
    templateUrl: './app.component.html',
//    directives: [NavbarComponent], 
    encapsulation: ViewEncapsulation.None
})
export class AppComponent {
    name = 'Questionnaire';
}
