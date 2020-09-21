/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runMain;

import bkap.entity.Categories;
import bkap.entity.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANG
 */
public class ShopManagement {

    /**
     * @param args the command line arguments
     */
    // Khởi tạo listCate
    static List<Categories> listCate = new ArrayList<>();
    //Khởi tạo listProduct
    static List<Product> listPro = new ArrayList<>();
    static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        // Khởi tạo đối tượng Scanner
        Scanner scan = new Scanner(System.in);
        //Khởi tạo đối tượng Shop Management
        ShopManagement shop = new ShopManagement();
        //Lay thong tin tu file categories vao listCate
        File fileCate = new File("categories.txt");
        if (fileCate.exists() && fileCate.isFile()) {
            shop.getInfomationFromFileCate();
        }

        //Lay thong tin tu file categories vao listProduct
        File fileProduct = new File("product.txt");
        if (fileProduct.exists() && fileProduct.isFile()) {
            shop.getInfomationFromFileProduct();
        }

        do {
            //Hien thi menu chinh
            shop.displayMainMenu();
            //Khởi tạo 1 số nguyên mainChoice dùng trong MainMenu
            int mainChoice = 0;
            //Validate lua chon Main Menu
            do {
                try {
                    mainChoice = Integer.parseInt(scan.nextLine());
                    break;
                } catch (Exception e) {
                    System.err.println("Vui long nhap 1 so nguyen tu 1-3");
                }
            } while (true);
            switch (mainChoice) {
                case 1:
                    //Khởi tạo 1 số nguyên cateChoice dùng trong Cate Menu
                    int cateChoice = 0;
                    //Ham lay thong tin cac danh muc duoc luu tru trong file categories.txt
                    do {
                        //Hien thi Menu danh muc 
                        shop.displayCateMenu();

                        //Validate cateChoice
                        do {
                            try {
                                cateChoice = Integer.parseInt(scan.nextLine());
                                break;

                            } catch (Exception e) {
                                System.err.println("Vui long nhap 1 so nguyen tu 1-5");
                            }
                        } while (true);
                        Categories cateAdd1 = new Categories(1, "Quan ao", "quan ao thoi", true, 0);
                        Categories cateAdd2 = new Categories(2, "Quan ao nam", "quan ao thoi", true, 1);
                        Categories cateAdd3 = new Categories(3, "Ao somi", "quan ao thoi", true, 2);
                        Categories cateAdd4 = new Categories(4, "Quan au ", "quan ao thoi", true, 2);
                        Categories cateAdd6 = new Categories(6, "Quan ao nu ", "quan ao thoi", true, 1);

                        Categories cateAdd5 = new Categories(5, "Trang suc", "Trang suc", true, 0);
                        Categories abc = new Categories();

                        // Them danh muc
                        listCate.add(cateAdd1);
                        listCate.add(cateAdd2);

                        listCate.add(cateAdd3);

                        listCate.add(cateAdd4);

                        listCate.add(cateAdd5);
                        listCate.add(cateAdd6);

                        switch (cateChoice) {
                            case 1:
                                // Khoi tao 1 so nguyen subCateChoice dung trong Sub Menu Cate
                                int subCateChoice = 0;
                                do {
                                    //Hien thi menu Danh sach danh muc
                                    shop.displaySubCateMenu();
                                    //Khởi tạo 1 số nguyên subCateChoice dùng trong Sub Menu Cate

                                    do {
                                        try {
                                            subCateChoice = Integer.parseInt(scan.nextLine());
                                            break;

                                        } catch (Exception e) {
                                            System.err.println("Vui long nhap 1 so nguyen tu 1-5");
                                        }
                                    } while (true);
                                    switch (subCateChoice) {
                                        case 1:
                                            shop.displayListCateData();
                                            break;
                                        case 2:
                                            shop.displayDetailsCateByNameSearch(scan);
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            shop.displayTreeCate();
                                            map.forEach((k, v) -> {
                                                System.out.println("key: " + k + " value: " + v);
                                            });
                                            break;

                                        default:
                                            System.out.println("Vui long chon chuc nang tu 1-3!");
                                    }
                                } while (subCateChoice != 3);

                                break;
                            case 2:
                                //Them nhieu danh muc
                                shop.inputCateData(scan);
                                break;

                            case 3:

                                shop.removeCateById(scan);
                                //Xoa danh muc
                                break;
                            case 4:
                                shop.displayDetailsCateByNameSearch(scan);
                                //Tim kiem danh muc
                                break;
                            case 5:

                                break;

                            default:
                                System.out.println("Vui long chon so tu 1 den 5!");
                        }

                    } while (cateChoice != 5);
                    break;
                case 2:
                    int productChoice = 0;
                    do {
                        //Hien thi Menu san pham
                        shop.displayProductMenu();
                        //Validate lua chon san pham
                        do {
                            try {
                                productChoice = Integer.parseInt(scan.nextLine());
                                break;
                            } catch (Exception e) {
                                System.err.println("Vui long chon 1 so nguyen tu 1-7");
                            }
                        } while (true);
                        switch (productChoice) {
                            case 1:
                                shop.inputProductData(scan);
                                break;
                            case 2:
                                shop.productCalProfit();
                                break;
                            case 3:
                                shop.displayMenuDetailsProduct();
                                int detailsProductChoice = 0;
                                do {
                                    try {
                                        detailsProductChoice = Integer.parseInt(scan.nextLine());
                                        switch (detailsProductChoice) {
                                            case 1:
                                                shop.displayProductListByCate();
                                                break;
                                            case 2:
                                                shop.searchProductByName(scan);
                                                break;
                                            case 3:
                                                break;
                                            default:
                                                System.out.println("Vui long nhap so tu 1-3");
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.err.println("Vui long nhap vao 1 so nguyen!");
                                    }
                                } while (detailsProductChoice != 3);
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:

                                break;
                            default:
                                System.out.println("Vui long nhap so tu 1-7!");

                        }
                    } while (productChoice != 7);
                    break;
                case 3:
                    shop.writeObjectToFileCate();
                    shop.writeObjectToFileProduct();
                    System.exit(0);
                default:
                    System.out.println("Vui long nhap 1 so tu 1-3");

            }
        } while (true);

    }

    //---------------------------MAIN CATEGORIES --------------------------------
    //Hàm hiển thị Main Menu
    public void displayMainMenu() {
        System.out.println("****************************MENU*********************");
        System.out.println("1. Quan ly danh muc");
        System.out.println("2. Quan ly san pham");
        System.out.println("3. Thoat");
        System.out.println("Su lua chon cua ban: ");

    }

    // Hàm hiển thị Cate Menu
    public void displayCateMenu() {
        System.out.println("**********************QUAN LY DANH MUC *****************");
        System.out.println("1. Danh sach danh muc");
        System.out.println("2. Them danh muc");
        System.out.println("3. Xoa danh muc");
        System.out.println("4. Tim kiem danh muc");
        System.out.println("5. Quay lai");
        System.out.println("Su lua chon cua ban: ");
    }

    // Hàm hiển thị Sub Cate Menu
    public void displaySubCateMenu() {
        System.out.println("**********************DANH SACH DANH MUC *****************");
        System.out.println("1. Danh sach cay danh muc");
        System.out.println("2. Thong tin chi tiet danh muc");
        System.out.println("3. Quay lai");
        System.out.println("Su lua chon cua ban: ");
    }
    /*
     --------------------------- END MAIN CATEGORIES-----------------------------------
     */
    /*
    
     ----------------------------------CATEGORIES-----------------------------

     */
    /*
     Ham lay thong tin duoc luu tren file categories.txt
    
     */

    public void writeObjectToFileCate() {
        try {
            FileOutputStream fos = new FileOutputStream("categories.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            List<Categories> listCateWrite = new ArrayList<>();
            for (Categories cate : listCate) {
                listCateWrite.add(cate);
            }
            oos.writeObject(listCateWrite);
            fos.close();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     Ham doc du lieu tu File
     */

    public void getInfomationFromFileCate() {

        try {

            FileInputStream fi = new FileInputStream("categories.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            listCate = (List<Categories>) ois.readObject();
            ois.close();
            fi.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    
    
     Hàm thêm danh mục dùng trong Cate Menu
     Case 2 CateMenu
     */

    public void inputCateData(Scanner scan) {
        System.out.println("Nhap so danh muc can them:");
        int number = 0;
        do {
            try {
                number = Integer.parseInt(scan.nextLine());
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Vui long nhap vao mot so lon hon 0!");
                }
            } catch (Exception e) {
                System.err.println("Vui long nhap vao 1 so nguyen!");
            }
        } while (true);
        for (int i = 0; i < number; i++) {

            System.out.println("Nhap ma danh muc: ");
            ShopManagement shopCate = new ShopManagement();
            Categories cate = new Categories();

            do {
                try {
                    int cateId = Integer.parseInt(scan.nextLine());
                    boolean checkCateIdExists = true;
                    //Kiểm tra xem CateId được nhập đã tồn tại hay chưa
                    for (Categories cate1 : listCate) {
                        if (cate1.getCatalogId() == cateId) {
                            checkCateIdExists = false;
                            break;
                        }
                    }
                    if (checkCateIdExists) {
                        // Sau khi kiểm tra nếu mã chưa tồn tại thì gán Id cho danh mục
                        cate.setCatalogId(cateId);

                        break;
                    } else {
                        //Nếu mã đã tồn tại thì thông báo lại
                        System.err.println("Ma danh muc " + cateId + " da ton tai! Vui long nhap lai!");
                    }
                } catch (Exception e) {
                    System.err.println("Ma danh muc phai la 1 so nguyen! Vui long nhap lai!");
                }
            } while (true);

            System.out.println("Nhap 0 neu la danh muc goc");
            System.out.println("Hoac chon ma danh muc  thuoc 1 trong so cac ma danh muc ben tren");
            shopCate.displayListCateId();
            do {
                System.out.println("Nhap ma danh muc cha");
                try {
                    int parentId = Integer.parseInt(scan.nextLine());
                    if (parentId == 0) {
                        cate.setParentId(parentId);
                        break;
                    } else if (parentId > 0) {
                        boolean checkParentIdExists = false;
                        for (Categories cate1 : listCate) {
                            if (cate1.getParentId() == parentId) {
                                checkParentIdExists = true;
                                break;
                            }
                        }
                        if (checkParentIdExists) {
                            int count = 0;

                            int number1 = parentId;

                            for (Categories cate1 : listCate) {
                                while (number1 != 0) {
                                    number1 = shopCate.checkLevelCateId(number1);
                                    count++;
                                }

                            }

                            if (count < 3) {
                                cate.setParentId(parentId);

                                break;
                            } else {
                                System.err.println("Ma danh muc cha vuot qua cap do cho phep la 3!Vui long kiem tra lai cap do danh muc!");

                                System.out.println("Nhap lai ma danh muc: ");

                            }
                        } else {
                            System.err.println("Ma danh muc cha khong trung! Vui long nhap lai");
                        }

                    } else {
                        System.err.println("Ma danh muc phai  la 1 so nguyen duong! Vui long nhap lai");
                    }
                } catch (Exception e) {
                    System.err.println("Ma danh muc cha phai la 1 so nguyen! Vui long nhap lai!");
                }
            } while (true);

            // Gọi hàm inputdata bên Class Categories
            cate.inputData();
            listCate.add(cate);
        }
    }

    /*
     Case 3 Cate Menu
     Hàm  xoa danh muc theo ten
     */
    public void removeCateById(Scanner scan) {
        System.out.println("Nhap  ma danh muc can xoa: ");
        int number = 0;
        do {
            try {
                number = Integer.parseInt(scan.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Ma danh muc can nhap 1 so nguyen! Vui long nhap lai!");
            }
        } while (true);
        List<Categories> removeList = new ArrayList<>();
        boolean check = false;
        for (Categories cate : listCate) {
            if (cate.getCatalogId() == number) {
                check = true;
                removeList.add(cate);
                break;
            }
        }
        boolean remove = listCate.remove(removeList);
        if (!check) {
            System.err.println("Khong tim thay danh muc co ma la " + number + "! ");
        }
        if (remove) {
            System.out.println("Danh muc co ma la " + number + " da bi xoa!");
        }
    }

    //Ham show ma danh muc
    public void displayListCateId() {
        for (Categories cate1 : listCate) {
            System.out.println("Ma danh muc: " + cate1.getCatalogId() + "\t Ten danh muc: " + cate1.getCatalogName());

        }
    }

    //Ham check ma danh muc
    // Nếu tham số nhập vào bằng với Ma danh muc thi ra về 1 số n bằng với parentId của danh muc cha
    public int checkLevelCateId(int parentId) {
        int n = 0;
        for (Categories cate1 : listCate) {
            if (cate1.getCatalogId() == parentId) {
                n = cate1.getParentId();
                break;
            }
        }
        return n;
    }
    /*
    
     ---------------------------------------- END CATEGORIES ----------------------------------------

     */

    //--------------------------------------------SUB CATEGORIES -----------------------------
    /*
     Hàm hiển thị thông tin chi tiết danh muc
    
     */
    public void displayListCateData() {

        for (Categories cate1 : listCate) {
            //Gọi hàm displayData bên Class Categories
            cate1.displayData();

        }

    }
    /*
     Hàm hiển thị cây danh muc 
     */

    public void displayTreeCate() {
        ShopManagement shop1 = new ShopManagement();
        for (Categories cate : listCate) {
            if (cate.getParentId() == 0) {
                map.put(cate.getCatalogId(), cate.getCatalogName());
            } else {
                shop1.addSubTreeCate(cate.getParentId());
            }
        }
    }
    /*
     Ham add subtree
     */

    /**
     *
     * @param <I>
     * @param <K>
     * @param id
     * @param value
     */
    public static void addSubTreeCate(int id) {
        for (Categories cate : listCate) {
            if (cate.getCatalogId() == id) {
                map.put(id, cate.getCatalogName());
            }
        }
    }
    /*
     Hiển thị thông tin chi tiết danh mục
     */

    public void displayDetailsCateByNameSearch(Scanner scan) {
        System.out.println("Nhap vao ten danh muc can xem thong tin: ");
        String nameSearchCate = scan.nextLine();
        boolean checkNameSearch = false;
        for (Categories cate : listCate) {
            if (cate.getCatalogName().startsWith(nameSearchCate)) {
                cate.displayData();
                checkNameSearch = true;
            }
        }
        if (!checkNameSearch) {
            System.out.println("Khong co danh muc nao co ten la " + nameSearchCate);
        }

    }
    /*
     //------------------------------------ END SUB CATEGORIES---------------------------------------
    
     */
    /*
     ------------------------------------------- PRODUCT ------------------------------------
   
     */

    //Ham hien thi san pham
    public void displayProductMenu() {
        System.out.println("********************** THONG TIN SAN PHAM *****************");
        System.out.println("1. Them san pham moi");
        System.out.println("2. Tinh loi nhuan san pham");
        System.out.println("3. Hien thi thong tin san pham");
        System.out.println("4. Sap xep san pham");
        System.out.println("5. Cap nhat thong tin san pham");
        System.out.println("6. Cap nhat trang thai san pham");
        System.out.println("7. Quay lai ");
        System.out.println("Su lua chon cua ban: ");

    }
    /*
     Ham ghi du lieu vao file product.txt
     */

    public void writeObjectToFileProduct() {
        try {
            FileOutputStream fos = new FileOutputStream("product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            List<Product> listProWrite = new ArrayList<>();
            for (Product product : listPro) {
                listProWrite.add(product);
            }
            oos.writeObject(listProWrite);
            fos.close();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     Ham doc thong tin tu file product.txt
     */

    public void getInfomationFromFileProduct() {

        try {

            FileInputStream fis = new FileInputStream("product.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listPro = (List<Product>) ois.readObject();
            ois.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     Case 1 Product Menu
     Them n san pham moi
     */

    public void inputProductData(Scanner scan) {
        System.out.println("Nhap so san pham can them moi: ");
        ShopManagement shopAddProduct = new ShopManagement();
        int number = 0;
        do {
            try {
                number = Integer.parseInt(scan.nextLine());
                if (number < 0) {
                    break;
                } else {
                    System.out.println("So san pham can lon hon 0! Vui long nhap lai!");
                }

            } catch (Exception e) {
                System.err.println("So san pham can nhap vao 1 so nguyen! Vui long nhap lai!");
            }
        } while (true);

        // Start for
        for (int i = 0; i < number; i++) {
            Product product = new Product();
            System.out.println("Nhap ma san pham");
            do {
                String strProductId = scan.nextLine().trim();
                if (strProductId.length() == 4 && strProductId.startsWith("C")) {
                    boolean checkInputProductIdExists = false;
                    for (Product pro : listPro) {
                        if (pro.getProductId().equals(strProductId)) {
                            checkInputProductIdExists = true;
                            break;
                        }
                    }
                    if (!checkInputProductIdExists) {
                        product.setProductId(strProductId);
                        break;
                    } else {
                        System.err.println("Ma san pham da ton tai! Vui long nhap lai");
                    }
                } else {
                    System.err.println("Ma san pham gom 4 ky tu va bat dau voi ky tu C ! Vui long nhap lai");
                }
            } while (true);

            // Nhap ten san pham
            System.out.println("Nhap ten san pham");
            do {
                String strProductName = scan.nextLine().trim();
                if (strProductName.length() >= 6 && strProductName.length() <= 50) {
                    boolean checkInputProductNameExists = false;
                    for (Product pro : listPro) {
                        if (pro.getProductId().equals(strProductName)) {
                            checkInputProductNameExists = true;
                            break;
                        }
                    }
                    if (!checkInputProductNameExists) {
                        product.setProductName(strProductName);
                        break;
                    } else {
                        System.err.println("Ten san pham da ton tai! Vui long nhap lai");
                    }
                } else {
                    System.err.println("Ten san pham gom 6-50 ky tu ! Vui long nhap lai");
                }
            } while (true);

            // Goi ham inputData ben Class Product
            product.inputData();
            // Hien thi danh sach ma danh muc san pham
            shopAddProduct.displayListCateId();
            System.out.println("Vui long chon mot trong nhung ma danh muc san pham ben tren!");
            int cateId = 0;
            do {
                try {
                    cateId = Integer.parseInt(scan.nextLine());
                    boolean checkCateIdExists = false;
                    Categories temp = new Categories();
                    // Kiem tra xem
                    for (Categories cate : listCate) {
                        if (cate.getCatalogId() == cateId) {
                            checkCateIdExists = true;
                            temp = cate;
                            break;
                        }
                    }
                    if (checkCateIdExists) {
                        product.setCatalog(temp);
                        break;
                    } else {
                        System.err.println("Ma danh muc san pham khong ton tai! Vui long nhap lai!");
                    }

                } catch (Exception e) {
                    System.err.println("Ma danh muc san pham can nhap vao la 1 so nguyen! Vui long nhap lai!");
                }
            } while (true);
            listPro.add(product);

        }

    }
    /*
     Case 2 Product : Tinh loi nhuan san pham
    
     */

    public void productCalProfit() {
        for (Product product : listPro) {
            product.calProfit();
        }
        System.out.println("Da tinh xong loi nhuan san pham");
    }
    /*
     End case 2 Product
     */

    /*
    
     -------------------- SUB DETAILS PRODUCT ----------------------
     Case 3 Product: Hien thi Menu thong tin san pham
     */
    public void displayMenuDetailsProduct() {
        System.out.println("*************THONG TIN SAN PHAM**************");
        System.out.println("1. Hien thi san pham theo danh muc");
        System.out.println("2. Hien ti chi tiet san pham ");
        System.out.println("3. Quay lai ");
        System.out.println("Su lua chon cua ban: ");
    }

    //Case 3.1
    //Hien thi san pham theo tung danh muc

    public void displayProductListByCate() {
        listCate.stream().forEach((listCate1) -> {
            int n = listCate1.getCatalogId();
            System.out.println("\t"+listCate1.getCatalogName());
            listPro.stream().filter((listPro1) -> (listPro1.getCatalog().getCatalogId()==n)).forEach((listPro1) -> {
                System.out.println(listPro1.getProductName());
            });
        });
    }
    //Case 3.2
    //Hien thi chi tiet san pham theo ten tim kiem
    public void searchProductByName(Scanner scan){
        System.out.println("Nhap ten san pham ban muon tim");
        String strNameSearch = scan.nextLine();
        boolean checkProductSearchByName = false;
        for (Product listPro1 :listPro) {
            if(listPro1.getProductName().contains(strNameSearch)){
                listPro1.displayData();
                checkProductSearchByName = true;
            }
           
        }
        if(!checkProductSearchByName){
            System.out.println("Khong tim thay san pham nao co ten "+strNameSearch);
        }
        
    }
    /*
     End Case 3 Product
     --------------------------------- END SUB DETAILS PRODUCT -------------------------------
     */

}
