import { Routes } from '@angular/router';
import { CertificateListComponent } from './components/certificates/certificate-list/certificate-list.component';
import { CertificateAddComponent } from './components/certificates/certificate-add/certificate-add.component';
import { SignedFileAddComponent } from './components/signed-files/signedfile-add/signedfile-add.component';
import { SignedFileListComponent } from './components/signed-files/signedfile-list/signedfile-list.component';

export const routes: Routes = [
  { path: '', redirectTo: '/certificates', pathMatch: 'full' },
  { path: 'certificates', component: CertificateListComponent },
  { path: 'certificates/add', component: CertificateAddComponent },
  { path: 'sign', component: SignedFileAddComponent },
  { path: 'signed-files', component: SignedFileListComponent }
];