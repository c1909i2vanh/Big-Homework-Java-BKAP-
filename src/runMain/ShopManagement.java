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
import java.util.List;
import java.util.Scanner;

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

    public static void main(String[] args) {

        // Khởi tạo đối tượng Scanner
        Scanner scan = new Scanner(System.in);
        //Khởi tạo đối tượng Shop Management
        ShopManagement shop = new ShopManagement();

        //Khởi tạo dối tượng fileCate
        File fileCate = new File("categories.txt");
        //Khởi tạo dối tượng fileProduct
        File fileProduct = new File("product.txt");
        //Nếu fileCate chưa tồn tại thì chạy hàm khởi tạo file
        if (!fileCate.exists()) {
            shop.writeObjectToFileCate();
        }
        //Nếu fileProduct chưa tồn tại thì chạy hàm khởi tạo file
        if (!fileProduct.exists()) {
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
                                                shop.displayListTreeCate();
                                                break;
                                            case 2:
                                                //Hiển thị chi tiết thông tin cac danh mục theo ten danh muc
                                                shop.displayDetailsCateByNameSearch(scan);
                                                break;
                                            case 3:
                                                //Out Sub Case 1.1
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
                                //Do không muốn xóa nên chuyển sang cập nhật trạng thái
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
        slowdownSpeed();
        System.out.println("**************************************MENU**************************************");
        System.out.println("1. Quan ly danh muc");
        System.out.println("2. Quan ly san pham");
        System.out.println("3. Thoat");
        System.out.println("Su lua chon cua ban: ");

    }
    /*
     *     ------------------------ MAIN MENU CATEGORIES   ----------------------
     */

    public void displayCateMenu() {
        slowdownSpeed();
        System.out.println("**********************************QUAN LY DANH MUC **********************************");
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
        slowdownSpeed();
        System.out.println("***********************************DANH SACH DANH MUC ***********************************");
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
        slowdownSpeed();
        System.out.println("************************************* QUAN LY SAN PHAM *************************************");
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
        slowdownSpeed();
        System.out.println("************************************* THONG TIN SAN PHAM*************************************");
        System.out.println("1. Hien thi san pham theo danh muc");
        System.out.println("2. Hien thi chi tiet san pham ");
        System.out.println("3. Quay lai ");
        System.out.println("Su lua chon cua ban: ");
    }
    /*
     *     ------------------- SUB MENU PRODUCT 4 ---------------------
     */

    public void displayMenuSortProduct() {
        System.out.println("*************************************  SAP XEP SAN PHAM*************************************");
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
     *   -------------------------   WRITE READ FILE CATE   ----------------
     */

    //*************   Ham lay thong tin duoc luu tren file categories.txt ***********
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
     ******************  Ham doc du lieu tu File ******************
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

    public void slowdownSpeed() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*
     **  --------------------------    CATEGORIES ----------------
     */
    /*
     **  --------------------------      CASE 1: CATEGORIES ----------------
     */
    /*
    
     *************** CASE 1.1 CATEGORIES    ******************
     * Hàm hiển thị thông tin chi tiết danh muc
    
     */

    /*
     Hiển thị thông tin chi tiết danh mục
     */
    public void displayListTreeCate() {

        System.out.println("Danh sách danh mục theo sơ đồ cây: ");
        int countLv1 = 1;
        for (Categories cate : listCate) {
            //In ra danh muc cap 1 nếu parentId == 0
            if (cate.getParentId() == 0) {
                System.out.println(countLv1 + ". " + cate.getCatalogName());
                int countLv2 = 1;
                for (Categories cate1 : listCate) {
                    //Nếu parenId trong vòng lặp 2 trùng CatalogId vòng 1 thì in ra
                    if (cate1.getParentId() == cate.getCatalogId()) {
                        System.out.println("\t" + countLv1 + "." + countLv2 + ". " + cate1.getCatalogName());
                        int countLv3 = 1;
                        for (Categories cate2 : listCate) {
                            //Nếu parenId vòng 3 trùng CatalogId vòng 2 thì in ra 
                            if (cate2.getParentId() == cate1.getCatalogId()) {
                                System.out.println("\t\t" + countLv1 + "." + countLv2 + "." + countLv3 + ". " + cate2.getCatalogName());
                                countLv3++;
                            }
                        }
                        countLv2++;
                    }
                }
                countLv1++;
            }
        }
        System.out.println("");

    }
    /*
     ****************** END CASE 1.1 CATEGORIES   *******************
     */

    /*
     //------------------ END CASE 1 CATEGORIES-----------
    
     /*
    
     --------------------- CASE 2  CATEGORIES ------------------
     Hàm thêm danh mục dùng trong Cate Menu
     
     */
    public void inputCateData(Scanner scan) {
        System.out.println("Nhap so danh muc can them:");
        ShopManagement shop = new ShopManagement();
        int number = 0;
        do {
            try {
                number = Integer.parseInt(scan.nextLine());
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Vui long nhap vao mot so lon hon 0!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui long nhap vao 1 so nguyen!");
            }
        } while (true);
        for (int i = 0; i < number; i++) {
            System.out.println("Nhap thong tin danh muc thu " + (i + 1));
            System.out.println("Nhap ma danh muc: ");
            ShopManagement shopCate = new ShopManagement();
            Categories cate = new Categories();
            do {
                try {
                    int cateId = Integer.parseInt(scan.nextLine());
                    //Kiểm tra xem CateId được nhập đã tồn tại hay chưa
                    if (!shop.checkCateIdExists(cateId)) {
                        // Sau khi kiểm tra nếu số nhập vào hợp lệ thì thêm mã danh mục mới
                        cate.setCatalogId(cateId);
                        break;
                    } else {
                        //Nếu mã danh mục đã tồn tại thì thông báo lại
                        System.err.println("Ma danh muc " + cateId + " da ton tai! Vui long nhap lai!");
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Ma danh muc phai la 1 so nguyen! Vui long nhap lai!");
                }
            } while (true);

            System.out.println("Nhap 0 neu la danh muc goc");
            System.out.println("Hoac chon ma danh muc  thuoc 1 trong so cac ma danh muc ben tren");
            shopCate.displayListCateCanAddCate();
            do {
                System.out.println("Nhap ma danh muc cha");
                try {
                    int parentId = Integer.parseInt(scan.nextLine());
                    boolean check = false;
                    if (parentId == 0) {
                        cate.setParentId(parentId);
                        break;
                    } else if (parentId > 0) {
                        //Kiểm tra nếu mã nhập vào thuộc list Cate thì tiếp tục
                        check = true;
                    } else {
                        System.err.println("Ma danh muc phai  la 1 so nguyen duong! Vui long nhap lai");
                    }
                    /*
                     ***  Kiểm tra mã danh mục đã tồn tại
                     */
                    if (check) {
                        if (shopCate.checkCateIdExists(parentId)) {
                            check = true;
                        } else {
                            check = false;
                            System.err.println("Ma danh muc cha khong ton tai! Vui long nhap ma danh muc cha bang 0 hoac thuoc 1 trong cac danh muc ơ tren!");
                        }
                    }

                    /* 
                     *  Kiểm tra mã danh mục cha không phải cấp 3 
                     *  Thì thêm mã danh mục vào danh sách
                     */
                    if (check) {
                        if (shopCate.checkLevelCateId(parentId) < 3) {
                            cate.setParentId(parentId);
                            break;
                        } else {
                            System.err.println("Ma danh muc cha phai bang 0 hoac la mot trong nhung ma ben tren! Vui long nhap lai ");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Ma danh muc cha phai la 1 so nguyen! Vui long nhap lai!");
                }
            } while (true);

            // Gọi hàm inputdata bên Class Categories
            cate.inputData();
            listCate.add(cate);
            System.out.println("Da them thanh cong danh muc" + cate.getCatalogName());
        }
    }

    /*
     *********** CASE 2 BONUS **********************
     */
    //Ham show ma danh muc  dùng trong case 2 CATEGORIES 
    public void displayListCateId() {
        //Hiển thị danh sách danh mục 
        ShopManagement shop = new ShopManagement();
        for (Categories cate1 : listCate) {
            int n = cate1.getParentId();
            int count = 0;
            while (n != 0) {
                n = shop.checkLevelCateId(n);
                count++;
                if (count == 3) {
                    break;
                }
            }
            if (count < 3) {
                System.out.println("Ma danh muc: " + cate1.getCatalogId() + "\t Ten danh muc: " + cate1.getCatalogName());

            }

        }
    }

    public void displayListCateCanAddCate() {
        //Hiển thị danh sách  mã danh mục cha có thể thêm danh mục con
        ShopManagement shop = new ShopManagement();
        listCate.stream().forEach((Categories cate1) -> {
            int number = shop.checkLevelCateId(cate1.getParentId());
            //Hệ thống cho phép dannh mục tối đa 3 cấp
            //Nếu n trả về nhỏ hơn 2 thì có thể thêm  danh mục vào danh sách
            if (number < 2) {
                System.out.println("Ma danh muc: " + cate1.getCatalogId() + "\t Ten danh muc: " + cate1.getCatalogName());
            }
        });
    }

    public void displayListCateIdCanAddProduct() {
        //Hiển thị danh sách mã danh mục có thể thêm sản phẩm
        ShopManagement shop = new ShopManagement();
//        listCate.stream().filter((cate1) -> (!shop.checkCateHaveChildren(cate1.getCatalogId()))).forEach((cate1) -> {
//            System.out.println("Ma danh muc: " + cate1.getCatalogId() + "\t Ten danh muc: " + cate1.getCatalogName());
//        });
        listCate.stream().forEach((cate) -> {
            boolean check = true;
            for (Categories cate1 : listCate) {
                if (cate.getCatalogId() == cate1.getParentId()) {
                    check = false;
                }
            }
            if (check) {
                System.out.println("Ma danh muc: " + cate.getCatalogId() + "\t Ten danh muc: " + cate.getCatalogName());
            }
        });
    }

    //Ham check ma danh muc dung trong CASE 2 CATEGORIES  
    // Nếu tham số nhập vào bằng với Ma danh muc thi ra về 1 số n bằng với parentId của danh muc cha
    public int getParentIdCate(int parentId) {
        //Lấy về mã danh mục cha
        int n = 0;
        for (Categories cate1 : listCate) {
            if (cate1.getCatalogId() == parentId) {
                n = cate1.getParentId();
                break;
            }
        }
        return n;
    }

    public boolean checkCateIdExists(int parentId) {
        //Kiểm tra mã danh mục có tồn tại hay không
        return listCate.stream().anyMatch((cate) -> (cate.getCatalogId() == parentId));
    }

    public int checkLevelCateId(int parentId) {
        //Kiểm tra cấp độ mã danh mục trong danh sách
        ShopManagement shopCate = new ShopManagement();
        int count = 0;
        for (Categories cate1 : listCate) {
            while (parentId != 0) {
                parentId = shopCate.getParentIdCate(parentId);
                count++;
                if (count == 3) {
                    // Ngừng vòng lặp nếu count vượt quá 3
                    break;
                }
            }
        }
        return count;
    }

    //Ham kiem tra Danh muc co ton tai  danh muc con hay ko
    public boolean checkCateHaveChildren(int number) {
        for (Categories cate : listCate) {
            if (cate.getCatalogId() == number) {
                for (Categories cate1 : listCate) {
                    if (cate.getCatalogId() == cate1.getParentId()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     --------------------- END CASE 2 CATEGORIES ----------------
     */
    /*
     -------------------- CASE 3 CATEGORIES -------------
    
     Hàm  cập nhật trạng thái danh mục
     */
    public void removeCateById(Scanner scan) {
        System.out.println("Nhap  ma danh muc can xoa: ");
        int number = 0;
        do {
            try {
                number = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Ma danh muc can nhap 1 so nguyen! Vui long nhap lai!");
            }
        } while (true);

        boolean check = false;
        for (Categories cate : listCate) {
            if (cate.getCatalogId() == number) {
                cate.setCatalogStatus(!cate.isCatalogStatus());
                check = true;
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
     -------------CASE 3 TEST ---
     */

    public void addChildren(int parent, List<Categories> children) {
        if (0 != parent) {
            for (Categories cate : listCate) {
                if (parent == cate.getParentId()) {
                    children.add(cate);
                    addChildren(cate.getCatalogId(), children);
                }

            }
        }
    }
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
                if (number > 0) {
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
            System.out.println("Nhap thong tin cho san pham thu " + (i + 1));
            Product product = new Product();
            System.out.println("Nhap ma san pham");
            do {
                String strInputId = scan.nextLine().trim();
                if (strInputId.length() == 4 && strInputId.startsWith("C")) {
                    //Kiểm tra mã sản phẩm đã tồn tại hay chưa
                    if (!shopAddProduct.checkProductIdExists(strInputId)) {
                        product.setProductId(strInputId);
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
                String strInputName = scan.nextLine().trim();
                if (strInputName.length() >= 6 && strInputName.length() <= 50) {
                    boolean checkProductNameExists = false;
                    for (Product pro : listPro) {
                        if (pro.getProductName().equals(strInputName)) {
                            checkProductNameExists = true;
                            break;
                        }
                    }
                    if (!checkProductNameExists) {
                        product.setProductName(strInputName);
                        break;
                    } else {
                        System.err.println("Ten san pham da ton tai! Vui long nhap lai");
                    }
                } else {
                    System.err.println("Ten san pham gom 6-50 ky tu ! Vui long nhap lai");
                }
            } while (true);

            // Goi ham inputData ben Class Product
            // product.inputData();
            /*  Hiển thị danh sách danh mục có thể thêm sản phẩm
             *  với điều kiện mã danh mục ấy ko có danh mục con
             */
            shopAddProduct.displayListCateIdCanAddProduct();
            System.out.println("Vui long chon mot trong nhung ma danh muc san pham ben tren!");
            //int cateId = 0;
            do {
                try {
                    int cateId = Integer.parseInt(scan.nextLine());
                    boolean check = false;
                    boolean checkCateId = false;
                    if (cateId > 0) {
                        for (Categories cate : listCate) {
                            if (cate.getCatalogId() == cateId) {
                                boolean checkParent = false;
                                for (Categories cate1 : listCate) {
                                    if (cate.getCatalogId() == cate1.getParentId()) {
                                        checkParent = true;
                                        break;
                                    }
                                }
                                if (!checkParent) {
                                    product.setCatalog(cate);
                                    checkCateId = true;
                                }
                                if (checkCateId) {
                                    break;
                                }
                            }
                        }
                        if (checkCateId) {
                            break;
                        } else {
                            System.err.println("Ma danh muc san pham khong hop le! Vui long nhap lai");
                        }
                    } else {
                        System.err.println("Ma danh muc san pham phai lon hon 0! Vui long nhap lai");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Ma danh muc san pham can nhap vao la 1 so nguyen! Vui long nhap lai!");
                }
            } while (true);
            product.inputData();
            listPro.add(product);
            System.out.println("Da them thanh cong san pham " + product.getProductName());

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
        System.out.println("Da tinh xong loi nhuan san pham!");
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
        ShopManagement shopCate = new ShopManagement();
        int countCate = 1;
        for (Categories cate : listCate) {
            int n = cate.getCatalogId();

            if (shopCate.checkCateHaveProduct(n) == 1) {

                System.out.println("Danh muc thu " + countCate + ": " + cate.getCatalogName());
                int countProduct = 1;
                for (Product product : listPro) {

                    if (product.getCatalog().getCatalogId() == n) {
                        System.out.println("\tSan pham thu " + countProduct + ": " + product.getProductName());
                        countProduct++;
                    }

                }
                countCate++;
            }

        }
    }

    public int checkCateHaveProduct(int cateId) {
        int number = 2;
        for (Categories cate : listCate) {
            for (Product product : listPro) {
                if (cateId == product.getCatalog().getCatalogId()) {
                    number = 1;
                    break;
                } else {
                    number = 0;
                }
            }
        }
        return number;
    }

    //----------- CASE 3.2 PRODUCT-------------
    //Hien thi chi tiet san pham theo ten tim kiem
    public void searchProductByName(Scanner scan) {
        System.out.println("Nhap ten san pham ban muon tim: ");
        String strNameSearch = scan.nextLine();
        boolean checkProductSearchByName = false;
        for (Product listPro1 : listPro) {
            if (listPro1.getProductName().contains(strNameSearch)) {
                listPro1.displayData();
                checkProductSearchByName = true;
            }

        }
        if (!checkProductSearchByName) {
            System.out.println("Khong tim thay san pham nao co ten " + strNameSearch + "! Vui long kiem tra lai!");
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
        System.out.println("Da sap xep xong danh sach san pham theo gia tang dan!");
        listPro.stream().forEach((product) -> {
            System.out.println("Ma san pham: " + product.getProductId() + " - Ten san pham: " + product.getProductName() + " - Gia ban ra: " + product.getExportPrice());
        });
    }
    /*
     ------------------- CASE 4.2 PRODUCT -------------
     **    Case 4.2 :Sap xep san pham theo loi nhaun giam dan
     */

    public void sortProductByProfitDesc() {
        Collections.sort(listPro, (Product o1, Product o2) -> Float.compare(o2.getProfit(), o1.getExportPrice()));
        System.out.println("Da sap xep xong danh sach san pham theo loi nhuan giam dan!");
        listPro.stream().forEach((product) -> {
            System.out.println("Ma san pham :" + product.getProductId() + " - Ten san pham: " + product.getProductName() + " - Loi nhuan: " + product.getProfit());
        });

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
//Kiểm tra tên sản phẩm có tồn tại

    public boolean checkProductIdExists(String productId) {
        return listPro.stream().anyMatch((product) -> (product.getProductId().equals(productId)));
    }

    public boolean checkProductNameExists(String productName) {
        return listPro.stream().anyMatch((product) -> (product.getProductId().equals(productName)));
    }

    public void updateProductData(Scanner scan) {
        System.out.println("Nhap ma san pham can cap nhat thong tin: ");
        ShopManagement shopUpdateProduct = new ShopManagement();
        String productId = scan.nextLine().trim();
        boolean checkCateIdExists = false;
        for (Product product : listPro) {
            if (product.getProductId().equals(productId)) {
                Product tempPro = new Product();
                tempPro.setProductId(productId);

                int productUpdateIndex = listPro.indexOf(product);
                // Hien thi danh sach ma danh muc san pham
                shopUpdateProduct.displayListCateIdCanAddProduct();
                System.out.println("Vui long chon mot trong nhung ma danh muc san pham ben tren!");
                System.out.println("Ban nhap ma danh muc cua san pham: ");
                do {

                    try {
                        int cateId = Integer.parseInt(scan.nextLine());
                        boolean checkCateId = false;
                        for (Categories cate : listCate) {
                            if (cate.getCatalogId() == cateId) {
                                boolean checkParent = false;
                                for (Categories cate1 : listCate) {
                                    if (cate.getCatalogId() == cate1.getParentId()) {
                                        checkParent = true;
                                        break;
                                    }
                                }
                                if (!checkParent) {
                                    tempPro.setCatalog(cate);
                                    checkCateId = true;
                                }
                                if (checkCateId) {
                                    break;
                                }
                            }
                        }
                        if (checkCateId) {
                            break;
                        } else {
                            System.err.println("Ma danh muc cha khong hop le!Vui long chon ma khac");
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Ma danh muc san pham can nhap vao la 1 so nguyen! Vui long nhap lai!");
                    }
                } while (true);
                // Nhap ten san pham
                System.out.println("Nhap ten san pham");
                do {
                    String strInputName = scan.nextLine().trim();
                    if (strInputName.length() >= 6 && strInputName.length() <= 50) {

                        if (!shopUpdateProduct.checkProductNameExists(strInputName)) {
                            tempPro.setProductName(strInputName);
                            break;
                        } else {
                            System.err.println("Ten san pham da ton tai! Vui long nhap lai");
                        }
                    } else {
                        System.err.println("Ten san pham gom 6-50 ky tu ! Vui long nhap lai");
                    }
                } while (true);

                tempPro.inputData();
                listPro.set(productUpdateIndex, tempPro);
                checkCateIdExists = true;
                break;
            }
        }
        if (checkCateIdExists) {
            System.out.println("Cap nhat thanh cong san pham " + productId);

        } else {
            System.err.println("Cap nhat that bai! Khong tim thay san pham " + productId);
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
        boolean checkupdate = false;
        for (Product product : listPro) {
            if (product.getProductId().equals(productId)) {
                product.setProductStatus(!product.isProductStatus());
                checkupdate = true;
                break;
            }
        }
        if (checkupdate) {
            System.out.println("Cap nhat trang thai san pham " + productId + " thanh cong!");
        } else {
            System.out.println("Khong tim thay san pham co ma la " + productId);

        }

    }
    /*
     *  ------------------ END CASE 6 PRODUCT --------------------
     */
}
