export interface ICar {
  id?: number;
  model?: string;
}

export class Car implements ICar {
  constructor(public id?: number, public model?: string) {}
}
