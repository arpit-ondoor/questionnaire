export interface IInputTypes
{
    id:number;
    inputTypeName:string;
    displayValue:string;
}

export interface IQuestionnaire
{
    questions: IQuestions[];
}
export interface IQuestions
{
    id: number;
    name: string;
    isChild: boolean;
    type: string;
    typeId: number;
    options:IOptions[];
}

export interface IOptions
{
    id: number;
    name: string;
    questions: IQuestions[];
}
