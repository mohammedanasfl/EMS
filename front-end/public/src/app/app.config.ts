import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { from } from '../../node_modules/rxjs/dist/types/index';

import { routes } from './app.routes';
import { EmployeeService } from './EmployeeService';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes),EmployeeService,
    provideHttpClient(withInterceptorsFromDi())]
  
};
