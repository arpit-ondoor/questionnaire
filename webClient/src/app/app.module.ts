import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { LocationStrategy, HashLocationStrategy, APP_BASE_HREF } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing, appRouterProviders } from './app.routing';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DataService } from './shared/services/data.service';
import { ConfigService } from './shared/utils/config.service';


import { QuestionComponent }            from './questions/question.component';
import { DynamicFormComponent }         from './questions/dynamic-form.component';
import { InputTypeSelectionComponent }  from './questions/input-type-selection.component';
import { QuestionOptionsComponent }     from './questions/question-options.component';
import { OptionComponent }              from './questions/option.component';
import { QuestionsComponent }           from './questions/questions.component';

@NgModule({
    declarations: [ AppComponent,
                    HomeComponent,
                    QuestionComponent, 
                    DynamicFormComponent,
                    QuestionOptionsComponent,
                    OptionComponent,
                    QuestionsComponent,
                    InputTypeSelectionComponent,
                   ],
    imports: [BrowserModule,
              FormsModule,
              ReactiveFormsModule,
              HttpModule,
              routing],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    providers: [
        appRouterProviders,
        ConfigService,
        DataService,
        [{provide: APP_BASE_HREF, useValue: '/'}],
        [{provide: LocationStrategy, useClass: HashLocationStrategy}]
    ],

    bootstrap: [AppComponent]
})
export class AppModule {}
