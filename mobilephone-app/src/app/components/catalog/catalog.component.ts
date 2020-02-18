import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { MobilePhone } from 'src/app/model/mobilephone';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {

  mobilephone : MobilePhone[] = [];
  constructor(private apiservice : ApiService) { }

  ngOnInit(): void {
    this.apiservice.getAllModels().subscribe(
      res=>{
        this.mobilephone = res;
      },
      err=>{
        console.log(err);    
      }
    );
  }

}
