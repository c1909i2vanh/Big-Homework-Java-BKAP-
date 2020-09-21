/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.entity;

import bkap.Intface.ICategories;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Categories implements Serializable, ICategories {

    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;
    private int parentId;

    public Categories() {
    }

    public Categories(int catalogId, int parentId) {
        this.catalogId = catalogId;
        this.parentId = parentId;
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus, int parentId) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
        this.parentId = parentId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public void inputData() {
        Scanner scan = new Scanner(System.in);

        // Nhap ten danh muc
        System.out.println("Nhap ten danh muc: ");
        do {

            String strName = scan.nextLine().trim();
            if (strName.length() >= 6 && strName.length() < 30) {
                this.catalogName = strName;
                break;
            } else {
                System.err.println("Ten danh muc phai nhap tu 6-30 ky tu! Vui long nhap lai!");
            }
        } while (true);

        //Nhap mo ta danh muc
        System.out.println("Nhap mo ta danh muc: ");
        do {

            String strDescrip = scan.nextLine().trim();

            if (!strDescrip.isEmpty()) {
                this.descriptions = strDescrip;
                break;
            } else {
                System.err.println("Mo ta danh muc khong duoc de trong! Vui long nhap lai!");
            }
        } while (true);

        // Nhap trang thai
          System.out.println("Nhap trang thai danh muc: ");
        do {
          
            String strStatus = scan.nextLine();
            if (strStatus.equals("true") || strStatus.equals("false")) {
                this.catalogStatus = Boolean.parseBoolean(strStatus);
                break;
            } else {
                System.err.println("Trang thai danh muc chi nhan true hoac false! Vui long nhap lai!");
            }
        } while (true);

    }

    @Override
    @SuppressWarnings("empty-statement")
    public void displayData() {

        System.out.printf("Ma danh muc: %s - Ten danh muc: %s \n", this.catalogId, this.catalogName);
        System.out.printf("\tMo ta danh muc: %s \n", this.descriptions);
        String str = (this.catalogStatus == true) ? "Hoat dong" : "Khong hoat dong";
        System.out.println("Danh muc cha " + this.parentId + "- Trang thai danh muc:" + str);

    }

}
