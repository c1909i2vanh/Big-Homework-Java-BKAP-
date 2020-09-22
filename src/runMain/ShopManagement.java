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

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import java.util.HashMap;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

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
        Categories cateAdd1 = new Categories(1, "Quan ao", "quan ao thoi", true, 0);
        Categories cateAdd2 = new Categories(2, "Quan ao nam", "quan ao thoi", true, 1);
        Categories cateAdd3 = new Categories(3, "Ao somi", "quan ao thoi", true, 2);
        Categories cateAdd4 = new Categories(4, "Quan au ", "quan ao thoi", true, 2);
        Categories cateAdd6 = new Categories(6, "Quan ao nu ", "quan ao thoi", true, 1);

        Categories cateAdd5 = new Categories(5, "Trang suc", "Trang suc", true, 0);

        // Them danh muc
        listCate.add(cateAdd1);
        listCate.add(cateAdd2);

        listCate.add(cateAdd3);

        listCate.add(cateAdd4);

        listCate.add(cateAdd5);
        listCate.add(cateAdd6);
        //Them Product
        Product proAdd1 = new Product("C121", "Quan levis1 ", "Quan bo", 10, 20, 0, "Quan vip1", true, cateAdd4);
        Product proAdd2 = new Product("C122", "Quan levis2 ", "Quan bo1", 10, 40, 0, "Quan vip2", true, cateAdd4);

        Product proAdd3 = new Product("C123", "Quan levis3 ", "Quan bo2", 10, 50, 0, "Quan vip3", true, cateAdd4);

        Product proAdd4 = new Product("C124", "Quan levis4 ", "Quan bo3", 10, 60, 0, "Quan vip4", true, cateAdd4);

        Product proAdd5 = new Product("C125", "Quan levis5 ", "Quan bo4", 10, 70, 0, "Quan vip5", false, cateAdd4);
        Product proAdd6 = new Product("C126", "Quan levis6 ", "Quan bo4", 10, 70, 0, "Quan vip5", false, cateAdd3);

        Product proAdd7 = new Product("C127", "Quan levis7 ", "Quan bo4", 10, 70, 0, "Quan vip5", false, cateAdd3);

        Product proAdd8 = new Product("C128", "Quan levis8 ", "Quan bo4", 10, 70, 0, "Quan vip5", false, cateAdd3);

        listPro.add(proAdd1);
        listPro.add(proAdd2);

        listPro.add(proAdd3);

        listPro.add(proAdd4);

        listPro.add(proAdd5);
        listPro.add(proAdd6);

        listPro.add(proAdd7);

        listPro.add(proAdd8);

        // Khởi tạo đối tượng Scanner
        Scanner scan = new Scanner(System.in);
        //Khởi tạo đối tượng Shop Management
        ShopManagement shop = new ShopManagement();
       
        //Khởi tạo dối tượng fileCate
        File fileCate = new File("categories.txt");
        //Khởi tạo dối tượng fileProduct
        File fileProduct = new File("product.txt");
        //Nếu fileCate chưa tồn tại thì chạy hàm khởi tạo file
        if(!fileCate.exists()){
              shop.writeObjectToFileCate();
        }
         //Nếu fileProduct chưa tồn tại thì chạy hàm khởi tạo file
        if(!fileProduct.exists()){
             shop.writeObjectToFileProduct();
        }
       //Nếu fileCate tồn tại và là file hợp lệ
        //Chạy hàm lấy thông tin vào listCate
        if (fileCate.exists() && fileCate.isFile()) {
            shop.getInfomationFromFileCate();
        }
        
        //Nếu fileProduct tồn tại và là file hợp lệ
        //Chạy hàm lấy thông tin vào listProduct
        if (fileProduct.exists() && fileProduct.isFile()) {
            shop.getInfomationFromFileProduct();
        }

        do {
            //Hiển thị menu chính
            shop.displayMainMenu();
            //Khởi tạo 1 số nguyên mainChoice dùng trong MainMenu
            int mainChoice = 0;
            //Validate mainChoice
            do {
                try {
                    mainChoice = Integer.parseInt(scan.nextLine());
                    break;
                } catch (Exception e) {
                    System.err.println("Vui long nhap 1 so nguyen tu 1-3");
                }
            } while (true);
            // Chạy chức năng theo lựa chọn mainChoice
            switch (mainChoice) {
                // Chức năng quản lý danh mục
                case 1:
                    //Khởi tạo 1 số nguyên cateChoice dùng trong Cate Menu
                    int cateChoice = 0;
                    
                    do {
                        //Hiển thị menu Cate
                        shop.displayCateMenu();

                        //Validate cateChoice
                        do {
                            try {
                                cateChoice = Integer.parseInt(scan.nextLine());
                                break;

                            } catch (NumberFormatException e) {
                                System.err.println("Vui long nhap 1 so nguyen tu 1-5");
                            }
                        } while (true);

                        switch (cateChoice) {
                            //Danh sách danh mục
                            //Quản lý danh sách danh mục
                            case 1:
                                // Thực hiện chức năng Sub Categories 
                                //Thực hiện chức năng  phụ thao tác trên danh mục sản phẩm
                                // Khoi tao 1 so nguyen subCateChoice dung trong Sub Menu Cate
                                int subCateChoice = 0;
                                do {
                                    //Hien thi menu Danh sach danh muc
                                    shop.displaySubCateMenu();
                                    //Khởi tạo 1 số nguyên subCateChoice dùng trong Sub Menu Cate

                                    try {
                                        subCateChoice = Integer.parseInt(scan.nextLine());

                                        switch (subCateChoice) {
                                            case 1:
                                                //Hiển thị danh sách danh mục theo dạng cây
                                                shop.displayListCateData();
                                                break;
                                            case 2:
                                                //Hiển thị chi tiết thông tin cac danh mục theo ten danh muc
                                                shop.displayDetailsCateByNameSearch(scan);
                                                break;
                                            case 3:
                                                //Out Sub Case 1.1
                                                break;
                                            case 4:
                                                //Hàm test
                                                shop.displayTreeCate();
                                                map.forEach((k, v) -> {
                                                    System.out.println("key: " + k + " value: " + v);
                                                });
                                                break;

                                            default:
                                                System.out.println("Vui long chon chuc nang tu 1-3!");
                                        }

                                    } catch (NumberFormatException e) {
                                        System.err.println("Vui long nhap 1 so nguyen tu 1-5");
                                    }

                                } while (subCateChoice != 3);

                                break;
                            case 2:
                                //Thêm nhiều danh mục 
                                shop.inputCateData(scan);
                                break;

                            case 3:
                                //Xóa danh mục theo mã danh mục
                                shop.removeCateById(scan);
                                
                                break;
                            case 4:
                                //Tìm kiếm danh mục theo tên
                                shop.displayDetailsCateByNameSearch(scan);                           
                                break;
                            case 5:
                                // Thoat Catemenu
                                break;

                            default:
                                System.out.println("Vui long chon so tu 1 den 5!");
                        }

                    } while (cateChoice != 5);
                    break;
                case 2:
                    //Quan ly san pham
                    int productChoice = 0;
                    do {
                        //Hiển thị Menu Product

                        shop.displayProductMenu();
                        //Validate  productChoice
                        do {
                            try {
                                productChoice = Integer.parseInt(scan.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.err.println("Vui long chon 1 so nguyen tu 1-7");
                            }
                        } while (true);
                        switch (productChoice) {
                            case 1:
                                //Nhập n sản phẩm
                                shop.inputProductData(scan);
                                break;
                            case 2:
                                //Tính lợi nhuận các sản phẩm đang có
                                shop.productCalProfit();
                                break;
                            case 3:
                                //Hiển thị thông tin sản phẩm theo yêu cầu
                                int detailsProductChoice = 0;
                                do {
                                    //Hiển thị Menu chi tiết sản phẩm
                                    shop.displayMenuDetailsProduct();
                                    try {
                                        detailsProductChoice = Integer.parseInt(scan.nextLine());
                                        switch (detailsProductChoice) {
                                            case 1:
                                                //Hiển thị danh sách sản phẩm theo từng danh mục 
                                                shop.displayProductListByCate();
                                                break;
                                            case 2:
                                                //Hiển thị sản phẩm theo tên tìm kiếm
                                                shop.searchProductByName(scan);
                                                break;
                                            case 3:
                                                //Đóng menu ci tiết sản phẩm
                                                break;
                                            default:
                                                System.out.println("Vui long nhap so tu 1-3");
                                        }

                                    } catch (NumberFormatException e) {
                                        System.err.println("Vui long nhap vao 1 so nguyen!");
                                    }
                                } while (detailsProductChoice != 3);
                                break;
                            case 4:
                                int sortProductChoice = 0;
                                do {
                                    //Hiển thị Menu sắp xếp sản phẩm
                                    shop.displayMenuSortProduct();

                                    try {
                                        sortProductChoice = Integer.parseInt(scan.nextLine());
                                        switch (sortProductChoice) {
                                            case 1:
                                                //Sắp xếp sản phẩm theo giá bán tăng dần
                                                shop.sortProductByExPriceAsc();
                                                break;
                                            case 2:
                                                //Sắp xếp sản phẩm theo lợi nhuận giảm dần
                                                shop.sortProductByProfitDesc();
                                                break;
                                            case 3:
                                                //Đóng menu sắp xếp sản phẩm
                                                break;
                                            case 4:
                                                //Hàm test danh sách sản phẩm
                                                shop.displayListProduct();
                                                break;
                                            default:
                                                System.out.println("Vui long nhap tu 1-3!");

                                        }

                                    } catch (NumberFormatException e) {
                                        System.err.println("Vui long nhap vao 1 so nguyen!");
                                    }

                                } while (sortProductChoice != 3);
                                break;
                            case 5:
                                //Cập nhật thông tin sản phẩm theo mã sản phẩm tùy chọn
                                shop.updateProductData(scan);
                                break;
                            case 6:
                                //Cập nhật trạng thái sản phẩm theo mã sản phẩm tùy chọn
                                shop.updateProductStatus(scan);
                                break;
                            case 7:
                                //Đóng Menu sản phẩm
                                break;
                            default:
                                System.out.println("Vui long nhap so tu 1-7!");

                        }
                    } while (productChoice != 7);
                    break;
                case 3:
                    //Ghi thông tin lên file categories 
                    shop.writeObjectToFileCate();
                    //Ghi thông tin lên file product.txt
                    shop.writeObjectToFileProduct();
                    //Thoát chương trình
                    System.exit(0);
                default:
                    System.out.println("Vui long nhap 1 so tu 1-3");

            }
        } while (true);

    }

    /*
     *
     *  ---------------o0o---------- MENU  ----------o0o------------------
     *
     */
    /*
     *
     *  --------------------------- MAIN MENU ----------------------
     * 
     */
    public void displayMainMenu() {
        System.out.println("****************************MENU*********************");
        System.out.println("1. Quan ly danh muc");
        System.out.println("2. Quan ly san pham");
        System.out.println("3. Thoat");
        System.out.println("Su lua chon cua ban: ");

    }
    /*
     *     ------------------------ MAIN MENU CATEGORIES   ----------------------
     */

    public void displayCateMenu() {
        System.out.println("**********************QUAN LY DANH MUC *****************");
        System.out.println("1. Danh sach danh muc");
        System.out.println("2. Them danh muc");
        System.out.println("3. Xoa danh muc");
        System.out.println("4. Tim kiem danh muc");
        System.out.println("5. Quay lai");
        System.out.println("Su lua chon cua ban: ");
    }
    /*
     *     ------------------------ SUB CATE MENU ----------------------
     */

    public void displaySubCateMenu() {
        System.out.println("**********************DANH SACH DANH MUC *****************");
        System.out.println("1. Danh sach cay danh muc");
        System.out.println("2. Thong tin chi tiet danh muc");
        System.out.println("3. Quay lai");
        System.out.println("Su lua chon cua ban: ");
    }
    /*
     *   -------------------------- MAIN MENU PRODUCT  ---------------------
     */

    //
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
     *    ------------------------- SUB MENU PRODUCT 3 -------------------
     */

    public void displayMenuDetailsProduct() {
        System.out.println("*************THONG TIN SAN PHAM**************");
        System.out.println("1. Hien thi san pham theo danh muc");
        System.out.println("2. Hien ti chi tiet san pham ");
        System.out.println("3. Quay lai ");
        System.out.println("Su lua chon cua ban: ");
    }
    /*
     *     ------------------- SUB MENU PRODUCT 4 ---------------------
     */

    public void displayMenuSortProduct() {
        System.out.println("************************* SAP XEP SAN PHAM******************");
        System.out.println("1. Sap xep san pham teo gia ban tang dan ");
        System.out.println("2. Sap xep san pham theo loi nhuan giam dan");
        System.out.println("3. Quay lai");
        System.out.println("Su lua chon cua ban: ");
    }
    /*
     -----------o0o------------ END MENU -----------o0o-------------------
     */
    //
    /*
     *   --------o0o-----------    CATEGORIES -----o0o--------------------
     */
    //
    /*
     *   --------------------------- WRITE READ FILE CATE -------------------
     */

    //     Ham lay thong tin duoc luu tren file categories.txt
    public void writeObjectToFileCate() {
        try {
            FileOutputStream fos = new FileOutputStream("categories.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            List<Categories> listCateWrite = new ArrayList<>();
            listCate.stream().forEach((cate) -> {
                listCateWrite.add(cate);
            });
            oos.writeObject(listCateWrite);
            fos.close();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     *               Ham doc du lieu tu File
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
     *
     *   -----------------    END WRITE READ CATEGORIES   ---------------
     *
    
     */
    /*
     **  --------------------------      CASE 1: CATEGORIES ----------------
     */
    /*
    
     *************** CASE 1.1 CATEGORIES    ******************
     * Hàm hiển thị thông tin chi tiết danh muc
    
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
     ****************** END CASE 1.1 CATEGORIES   *******************
     */

    /*
     Ham add subtree
     */
    /**
     *
     ********** TEST CATEGORIES
     *
     *******
     * @param id
     */
    public static void addSubTreeCate(int id) {
        listCate.stream().filter((cate) -> (cate.getCatalogId() == id)).forEach((cate) -> {
            map.put(id, cate.getCatalogName());
        });
    }
    /*
     Hiển thị thông tin chi tiết danh mục
     */

    public void displayListCateData() {

        for (Categories cate1 : listCate) {
            //Gọi hàm displayData bên Class Categories
            cate1.displayData();

        }

    }
    /*
     //------------------ END CASE 1 CATEGORIES-----------
    
     /*
    
     --------------------- CASE 2  CATEGORIES ------------------
     Hàm thêm danh mục dùng trong Cate Menu
     
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
                            if (cate1.getCatalogId() == parentId) {
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
                                    if (count >= 3) {
                                        break;
                                    }
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
     *********** CASE 2 BONUS **********************
     */
    //Ham show ma danh muc  dùng trong case 2 CATEGORIES 
    public void displayListCateId() {
        for (Categories cate1 : listCate) {
            System.out.println("Ma danh muc: " + cate1.getCatalogId() + "\t Ten danh muc: " + cate1.getCatalogName());

        }
    }

    //Ham check ma danh muc dung trong CASE 2 CATEGORIES  
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
     --------------------- END CASE 2 CATEGORIES ----------------
     */


    /*
     -------------------- CASE 3 CATEGORIES -------------
    
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
                int index = listCate.indexOf(cate);
                listCate.remove(index);
                break;
            }
        }

        if (!check) {
            System.err.println("Khong tim thay danh muc co ma la " + number + "! ");
        } else {
            System.out.println("Da xoa danh muc co ma la " + number);
        }

    }
    /*
     -------------------------- END CASE 3 CATE GORIES ------------------
     */
    /*
     ****************** CASE 4 CATEGORIES  ************************
     **Hàm hiển thị cây danh muc 
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
     ****************   END CASE 4 CATEGORIES ****************
     */

    /*
    
     ------------o0o0o0o------ END CATEGORIES -----o0o0o0o------

     */
    /*
     -------------o0o0o0o--------- PRODUCT ---------o0o0o0o-------
   
     */
    /*
     -----------------    END WRITE READ PRODUCT   ---------------
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
     -----------------    END WRITE READ PRODUCT   ---------------
     */
    /*
     --------------------- CASE 1 PRODUCT ----------------
     
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

            } catch (NumberFormatException e) {
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
            //int cateId = 0;
            do {
                try {
                    int cateId = Integer.parseInt(scan.nextLine());
                    boolean checkCateIdExists = false;
                    Categories temp = new Categories();
                    // Kiem tra xem ma danh muc nhap vao co ton tai hay chua
                    // Neu co thi gan gia tri cua Categories cho bien temp

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

                } catch (NumberFormatException e) {
                    System.err.println("Ma danh muc san pham can nhap vao la 1 so nguyen! Vui long nhap lai!");
                }
            } while (true);
            listPro.add(product);

        }

    }
    /*
     ----------------- END CASE 1 PRODUCT --------------------
    
     */
    /*
     ------------------- CASE 2 PRODUCT ---------------------
     Case 2 Product : Tinh loi nhuan san pham
    
     */

    public void productCalProfit() {
        listPro.stream().forEach((product) -> {
            product.calProfit();
        });
        System.out.println("Da tinh xong loi nhuan san pham");
    }
    /*
     -------------------- END CASE 2 PRODUCT -----------------
     End case 2 Product
     */

    /*
    
     
     --------------------- CASE 3 PRODUCT ------------------------
  
     */
    //-----------------CASE 3.1 PRODUCT -----------------------------
    //Hien thi san pham theo tung danh muc
    public void displayProductListByCate() {
        listCate.stream().forEach((listCate1) -> {
            int n = listCate1.getCatalogId();
            System.out.println("\t" + listCate1.getCatalogName());
            listPro.stream().filter((listPro1) -> (listPro1.getCatalog().getCatalogId() == n)).forEach((listPro1) -> {
                System.out.println("\t \t" + listPro1.getProductName());

            });

        });
    }

    //----------- CASE 3.2 PRODUCT-------------
    //Hien thi chi tiet san pham theo ten tim kiem
    public void searchProductByName(Scanner scan) {
        System.out.println("Nhap ten san pham ban muon tim");
        String strNameSearch = scan.nextLine();
        boolean checkProductSearchByName = false;
        for (Product listPro1 : listPro) {
            if (listPro1.getProductName().contains(strNameSearch)) {
                listPro1.displayData();
                checkProductSearchByName = true;
            }

        }
        if (!checkProductSearchByName) {
            System.out.println("Khong tim thay san pham nao co ten " + strNameSearch);
        }

    }
    /*
   
     *   ---------------------- END CASE3 PRODUCT: SUB DETAILS PRODUCT ---------
     */
    /*
     *   ---------------------------- CASE 4 PRODUCT --------------------------
     */

    /*
     *   --------------------- CASE 4.1 PRODUCT-------------------
     **   Case 4.1 Sắp xếp sản phẩm theo giá bán tăng dần
     */
    public void sortProductByExPriceAsc() {
        Collections.sort(listPro, (Product o1, Product o2) -> Float.compare(o1.getExportPrice(), o2.getExportPrice()));
    }
    /*
     ------------------- CASE 4.2 PRODUCT -------------
     **    Case 4.2 :Sap xep san pham theo loi nhaun giam dan
     */

    public void sortProductByProfitDesc() {
        Collections.sort(listPro, (Product o1, Product o2) -> Float.compare(o2.getProfit(), o1.getExportPrice()));
    }
    /*
     *   ------------------- HAM TEST CASE 4 PRODUCT ------------
     ***    Test List Product
     */

    public void displayListProduct() {
        listPro.stream().forEach((product) -> {
            product.displayData();
        });
    }
    /*
     *    ---------------- END CASE 4 PRODUCT -----------------
     */
    /*
     *   -------------------- CASE 5 PRODUCT ---------------------
     **  Cap nhat thong tin san pham
     */

    public void updateProductData(Scanner scan) {
        System.out.println("Nhap ma san pham can cap nhat thong tin: ");
        ShopManagement shopUpdateProduct = new ShopManagement();
        String productId = scan.nextLine().trim();
        if (productId.length() == 4 && productId.startsWith("C")) {
            boolean checkProductIdExists = false;
            for (Product product : listPro) {
                if (product.getProductId().equals(productId)) {
                    Product tempPro = new Product();
                    tempPro.setProductId(productId);
                    tempPro.inputData();
                    int a = listPro.indexOf(product);
                    // Hien thi danh sach ma danh muc san pham
                    shopUpdateProduct.displayListCateId();
                    System.out.println("Vui long chon mot trong nhung ma danh muc san pham ben tren!");
                    do {
                        try {
                            int cateId = Integer.parseInt(scan.nextLine());
                            boolean checkCateIdExists = false;
                            Categories temp = new Categories();
                            // Kiem tra xem ma danh muc nhap vao co ton tai hay chua
                            // Neu co thi gan gia tri cua Categories cho bien temp

                            for (Categories cate : listCate) {
                                if (cate.getCatalogId() == cateId) {
                                    checkCateIdExists = true;
                                    temp = cate;
                                    break;
                                }
                            }
                            if (checkCateIdExists) {
                                tempPro.setCatalog(temp);
                                break;
                            } else {
                                System.err.println("Ma danh muc san pham khong ton tai! Vui long nhap lai!");
                            }

                        } catch (NumberFormatException e) {
                            System.err.println("Ma danh muc san pham can nhap vao la 1 so nguyen! Vui long nhap lai!");
                        }
                    } while (true);

                    listPro.set(a, tempPro);

                    checkProductIdExists = true;
                    break;
                }
            }
            if (!checkProductIdExists) {
                System.err.println("Ma san pham khong dung! Vui long kiem tra lai  ");
            } else {

            }
        } else {
            System.err.println("Vui long nhap ma san pham co 4 ky tu va bat dau bang ky tu C !");
        }

    }


    /*
     *  ----------------- END CASE 5 PRODUCT -----------------------
     */
    /*
     *  ----------------- CASE 6 PRODUCT -----------------------
     ** Cap nhat trang thai san pham
     */
    public void updateProductStatus(Scanner scan) {
        System.out.println("Nhap ma san pham can cap nhat trang thai: ");
        String productId = scan.nextLine().trim();
        if (productId.length() == 4 && productId.startsWith("C")) {
            listPro.stream().filter((product) -> (product.getProductId().equals(productId))).forEach((product) -> {
                product.setProductStatus(!product.isProductStatus());
            });

        } else {
            System.err.println("Vui long nhap ma san pham co 4 ky tu va bat dau bang ky tu C !");
        }

    }
    /*
     *  ------------------ END CASE 6 PRODUCT --------------------
     */
}
