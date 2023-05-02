# Hướng dẫn cài đặt và sử dụng Project

========================================

# Yêu cầu hệ thống:
Để cài đặt và chạy project, bạn cần phải đáp ứng các yêu cầu hệ thống sau:
1. JDK (Java Development Kit)
2. IDE (Integrated Development Environment) như Eclipse
3. Cơ sở dữ liệu MySQL

========================================<br>
# Tạo cơ sở dữ liệu:
1. Mở MySQL Workbench
2. Sao chép, dán các Lệnh MySql sau:<br>
```
   CREATE TABLE `nhanvien` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `ten` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
    `tuoi` INT(11) NOT NULL,
	  `gioiTinh` INT(11) NOT NULL,
	  `chucVu` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	  `luong` INT(11) NOT NULL,
	  PRIMARY KEY (`id`) USING BTREE
    )
   CREATE TABLE `user` (
	  `userName` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	  `password` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	  `email` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	  PRIMARY KEY (`userName`) USING BTREE
    )<br>
  INSERT INTO user VALUES('quang','123456a', 'quang@gmail.com')
```

========================================

#Các bước cài đặt:
1. Tải và cài đặt JDK cho máy tính của bạn bằng cách tải phiên bản phù hợp với hệ điều hành của bạn
2. Clone dự án từ Github bằng cách làm theo các bước sau đây:<nr>
        Mở Eclipse trên máy tính của bạn.<br>
        Chọn menu `File > Import` để mở hộp thoại `Import`.<br>
        Chọn `Git > Projects from Git` và nhấn nút `Next`.<br>
        Chọn `Clone URI` và nhấn nút `Next`.<br>
        Dán địa chỉ URL 'https://github.com/huycamm/quanLyNhanVien.git' vào trường `URI` trong hộp thoại `Clone Git Repository` và nhấn nút `Next`.<br>
        Chọn `Import Existing Eclipse Projects` và nhấn nút `Next`.<br>
        Chọn project bạn mới clone và nhấn nút `Finish`.<br>
        Project của bạn sẽ được clone từ GitHub và mở trong Eclipse.<br>
 3. Chuột phải vào project > Run as > Java Application > Test > OK
 4. Tên đăng nhập và mật khẩu mặc định là "huy" và "123456a"
