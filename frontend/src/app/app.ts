import { ChangeDetectorRef, Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

interface Sale {
  SalesOrderID: number;
  OrderDate: string;
  TotalDue: number;
  ProductID: number;
  ProductName: string;
  OrderQty: number;
  UnitPrice: number;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  private http = inject(HttpClient);
  private cdr = inject(ChangeDetectorRef);

  sales: Sale[] = [];

  loading = false;
  error = '';

  responseTime: number | null = null;

  loadSales(): void {

    this.loading = true;
    this.error = '';
    this.responseTime = null;

    const start = performance.now();

    this.http
      .get<Sale[]>('http://localhost:8080/api/sales')
      .subscribe({

        next: (data) => {

          this.sales = data;

          this.responseTime =
            Math.round(performance.now() - start);

          this.loading = false;

          // Angular is running zoneless.
          // Tell it that the component changed.
          this.cdr.markForCheck();
        },

        error: (error) => {

          console.error(error);

          this.error =
            'Could not connect to the Spring Boot API.';

          this.loading = false;

          this.cdr.markForCheck();
        }

      });
  }

  clearData(): void {

    this.sales = [];
    this.responseTime = null;
    this.error = '';

    this.cdr.markForCheck();
  }

  get previewSales(): Sale[] {
    return this.sales.slice(0, 25);
  }
}
