import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'car',
        loadChildren: () => import('./car/car/car.module').then(m => m.CarCarModule),
      },
      {
        path: 'owner',
        loadChildren: () => import('./owner/owner/owner.module').then(m => m.OwnerOwnerModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class GatewayEntityModule {}
