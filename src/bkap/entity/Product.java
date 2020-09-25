/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.entity;

import bkap.Intface.IProduct;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Product implements IProduct,Serializable {

    private String productId;
    private String productName;
    private String title;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private String descriptions;
    private boolean productStatus;
    private Categories catalog;

    public Product() {
    }

    public Product(String productId, String productName, String title, float importPrice, float exportPrice, float profit, String descriptions, boolean productStatus, Categories catalog) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.catalog = catalog;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Categories getCatalog() {
        return catalog;
    }

    public void setCatalog(Categories catalog) {
        this.catalog = catalog;
    }

    @Override
    public void inputData() {
        Scanner scan = new Scanner(System.in);

        //Nhap tieu de san pham
         System.out.println("Nhap tieu  de cho san pham: ");
        do {
         
            String str = scan.nextLine().trim();
            if (str.length() >= 6 && str.length() <= 30) {
                this.title = str;
                break;

            } else {
                System.err.println("Tieu de san pham phai tu 6-30 ky tu!Vui long nhap lai");
            }
        } while (true);

        //Nhap gia san pham
          System.out.println("Nhap gia nhap  vao cua san pham:");
        do {
            try {
              
                this.importPrice = Float.parseFloat(scan.nextLine());
                if (this.importPrice > 0) {
                    break;
                } else {
                    System.err.println("Gia san pham phai lon hon 0! Vui long nhap lai!");
                }
            } catch (Exception e) {
                System.err.println("Gia san pham phai la 1 so thuc!Vui long nhap lai!");
            }
        } while (true);
        
        //Nhap gia ban ra cua san pham
         System.out.println("Moi ban nhap gia ban cua san pham: ");
        do {            
           
            try {
                this.exportPrice = Float.parseFloat(scan.nextLine());
                if(this.exportPrice>(this.importPrice*IProduct.MIN_INTEREST_RATE)){
                    break;
                }else{
                    System.err.println("Gia ban ra phai lon hon "+IProduct.MIN_INTEREST_RATE+" lan! Vui long nhap lai!");
                }
            } catch (Exception e) {
                System.err.println("Gia ban ra cua san pham phai la 1 so thuc vui long nhap lai");
            }
        } while (true);
        
        //Nhap mo ta san pham
         System.out.println("Nhap mo ta cho san pham");
        do {            
           
            this.descriptions = scan.nextLine().trim();
            if(this.descriptions.length()!=0){
                break;
            }else{
                System.err.println("Mo ta san pham khong duoc de trong!Vui long nhap lai");
            }
            
        } while (true);
        
        //Nhap trang thai cho san pham
        System.out.println("Nhap trang thai cho san pham: ");
        do {            
            String strStatus = scan.nextLine().trim();
            if(strStatus.equals("true")||strStatus.equals("false")){
                this.productStatus = Boolean.parseBoolean(strStatus);
                break;
            }else{
                System.err.println("Trang thai san pham chi nhan true hoac false! Vui long nhap lai!");
            }
        } while (true);
        

    }

    @Override
    public void displayData() {
        System.out.printf("Ma SP: %s - Ten SP: %s -Tieu de san pham: %s \n",this.productId,this.productName,this.title);
        System.out.printf("Gia nhap vao: %.1f - Gia ban ra: %.1f - Loi nhuan: %.1f \n",this.importPrice,this.exportPrice,this.profit);     
        System.out.println("Trang thai san pham: "+ (this.productStatus ?"Hoat dong":"Khong hoat dong"));
        System.out.println("Mo ta san pham: "+this.descriptions);
        System.out.println("Ma danh muc: "+this.catalog.getCatalogId()+" - Ten danh muc: "+this.catalog.getCatalogName());
        System.out.println("");
      
       }

    @Override
    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
        }

}
