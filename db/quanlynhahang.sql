/*
Navicat MySQL Data Transfer

Source Server         : Connect-Ecommerce
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : quanlynhahang

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-04-15 16:16:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `banghe`
-- ----------------------------
DROP TABLE IF EXISTS `banghe`;
CREATE TABLE `banghe` (
  `MaBan` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVienTruc` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoLuongKhach` int(11) NOT NULL,
  `SoKhachToiDa` int(11) NOT NULL,
  `MaTrangThai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `xoa` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`MaBan`),
  KEY `fk_BG_NV` (`MaNhanVienTruc`),
  KEY `fk_BG_TT` (`MaTrangThai`),
  CONSTRAINT `fk_BG_NV` FOREIGN KEY (`MaNhanVienTruc`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_BG_TT` FOREIGN KEY (`MaTrangThai`) REFERENCES `trangthai` (`MaTT`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of banghe
-- ----------------------------
INSERT INTO `banghe` VALUES ('B101', null, '0', '4', 'TTBG01', '');
INSERT INTO `banghe` VALUES ('B102', null, '0', '2', 'TTBG01', '');
INSERT INTO `banghe` VALUES ('B201', null, '0', '2', 'TTBG01', '');
INSERT INTO `banghe` VALUES ('B202', null, '0', '4', 'TTBG01', '');
INSERT INTO `banghe` VALUES ('B301', null, '0', '6', 'TTBG01', '');
INSERT INTO `banghe` VALUES ('B302', null, '0', '6', 'TTBG01', '');

-- ----------------------------
-- Table structure for `bangluong`
-- ----------------------------
DROP TABLE IF EXISTS `bangluong`;
CREATE TABLE `bangluong` (
  `MaLuong` int(10) NOT NULL AUTO_INCREMENT,
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayGioNhan` datetime NOT NULL,
  `TongCaLam` int(11) NOT NULL,
  `VangCoPhep` int(11) DEFAULT NULL,
  `VangKhongPhep` int(11) DEFAULT NULL,
  `ThoiGianTre` int(11) DEFAULT NULL,
  `TongLuong` int(11) NOT NULL,
  PRIMARY KEY (`MaLuong`),
  KEY `fk_BL_NV` (`MaNhanVien`),
  CONSTRAINT `fk_BL_NV` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of bangluong
-- ----------------------------

-- ----------------------------
-- Table structure for `calamviec`
-- ----------------------------
DROP TABLE IF EXISTS `calamviec`;
CREATE TABLE `calamviec` (
  `MaCa` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `GioBatDau` time NOT NULL,
  `GioKetThuc` time NOT NULL,
  PRIMARY KEY (`MaCa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of calamviec
-- ----------------------------

-- ----------------------------
-- Table structure for `chitietgoimenu`
-- ----------------------------
DROP TABLE IF EXISTS `chitietgoimenu`;
CREATE TABLE `chitietgoimenu` (
  `MaCTG` int(10) NOT NULL AUTO_INCREMENT,
  `MaBan` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaMenu` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGoi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuongGoi` int(11) NOT NULL,
  `GhiChu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ThoiGianGoi` time NOT NULL,
  `MaTrangThai` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaCTG`),
  KEY `fk_CTGM_BG` (`MaBan`),
  KEY `fk_CTGM_MN` (`MaMenu`),
  KEY `fk_CTGM_TT` (`MaTrangThai`),
  CONSTRAINT `fk_CTGM_BG` FOREIGN KEY (`MaBan`) REFERENCES `banghe` (`MaBan`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_CTGM_MN` FOREIGN KEY (`MaMenu`) REFERENCES `menu` (`MaMenu`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_CTGM_TT` FOREIGN KEY (`MaTrangThai`) REFERENCES `trangthai` (`MaTT`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietgoimenu
-- ----------------------------

-- ----------------------------
-- Table structure for `chitiethoadon`
-- ----------------------------
DROP TABLE IF EXISTS `chitiethoadon`;
CREATE TABLE `chitiethoadon` (
  `MaCTHD` int(10) NOT NULL AUTO_INCREMENT,
  `MaHD` int(10) NOT NULL,
  `MaMenu` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGoi` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL,
  PRIMARY KEY (`MaCTHD`),
  KEY `fk_CTHD_HD` (`MaHD`),
  KEY `fk_CTHD_Menu` (`MaMenu`),
  CONSTRAINT `fk_CTHD_HD` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_CTHD_Menu` FOREIGN KEY (`MaMenu`) REFERENCES `menu` (`MaMenu`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitiethoadon
-- ----------------------------

-- ----------------------------
-- Table structure for `hoadon`
-- ----------------------------
DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE `hoadon` (
  `MaHD` int(10) NOT NULL AUTO_INCREMENT,
  `TenKhachHang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNhanVien` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaBan` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuongKhach` int(11) NOT NULL,
  `NgayGio` datetime NOT NULL,
  `TongTien` int(11) NOT NULL,
  `ThanhToan` bit(1) NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `fk_HD_NV` (`MaNhanVien`),
  KEY `fk_HD_BG` (`MaBan`),
  CONSTRAINT `fk_HD_BG` FOREIGN KEY (`MaBan`) REFERENCES `banghe` (`MaBan`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_HD_NV` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hoadon
-- ----------------------------

-- ----------------------------
-- Table structure for `lichcalamviec`
-- ----------------------------
DROP TABLE IF EXISTS `lichcalamviec`;
CREATE TABLE `lichcalamviec` (
  `MaLich` int(10) NOT NULL AUTO_INCREMENT,
  `ThoiGian` date NOT NULL,
  `MaCa` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaTrangThai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ThoiGianTre` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaLich`),
  KEY `fk_LCLV_NV` (`MaNhanVien`),
  KEY `fk_LCLV_CLV` (`MaCa`),
  KEY `fk_LCLV_TT` (`MaTrangThai`),
  CONSTRAINT `fk_LCLV_CLV` FOREIGN KEY (`MaCa`) REFERENCES `calamviec` (`MaCa`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_LCLV_NV` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_LCLV_TT` FOREIGN KEY (`MaTrangThai`) REFERENCES `trangthai` (`MaTT`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of lichcalamviec
-- ----------------------------

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MaMenu` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGoi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Hinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Gia` int(11) NOT NULL,
  `KhuyenMai` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`MaMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('MN01', 'Gà Quay', '', '120000', '0');
INSERT INTO `menu` VALUES ('MN02', 'Gỏi Ngủ Sắc', '', '80000', '0');
INSERT INTO `menu` VALUES ('MN03', 'Giò Heo Đút Lò Hoa Tiêu', '', '199000', '0');
INSERT INTO `menu` VALUES ('MN04', 'Đậu Hủ Sinh Thái', '', '70000', '0');
INSERT INTO `menu` VALUES ('MN05', 'Lẩu Cua Đồng', '', '140000', '0');
INSERT INTO `menu` VALUES ('MN06', 'Vịt Quay Bắc Kinh', '', '145000', '0');
INSERT INTO `menu` VALUES ('MN07', 'Bia Hieneken', '', '21000', '0');
INSERT INTO `menu` VALUES ('MN08', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN09', 'Sinh Tố Sầu Riêng', '', '30000', '0');
INSERT INTO `menu` VALUES ('MN10', 'Sinh T? S?u Riêng', '', '30000', '0');
INSERT INTO `menu` VALUES ('MN11', 'Sinh T? S?u Riêng', '', '30000', '0');
INSERT INTO `menu` VALUES ('MN12', 'Sinh T? S?u Riêng', '', '30000', '0');
INSERT INTO `menu` VALUES ('MN13', 'Sinh T? S?u Riêng', '', '30000', '0');
INSERT INTO `menu` VALUES ('MN14', 'Sinh T? S?u Riêng', '', '30000', '0');
INSERT INTO `menu` VALUES ('MN15', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN16', 'Sinh T? S?u Riêng', '', '30000', '0');
INSERT INTO `menu` VALUES ('MN18', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN19', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN20', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN21', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN22', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN23', 'L?u Cua ??ng', '', '140000', '0');
INSERT INTO `menu` VALUES ('MN24', 'L?u Cua ??ng', '', '140000', '0');
INSERT INTO `menu` VALUES ('MN25', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN26', 'V?t Quay B?c Kinh', '', '145000', '0');
INSERT INTO `menu` VALUES ('MN27', 'V?t Quay B?c Kinh', '', '145000', '0');
INSERT INTO `menu` VALUES ('MN28', 'Sting Dâu', '', '15000', '0');
INSERT INTO `menu` VALUES ('MN29', 'L?u Cua ??ng', '', '140000', '0');
INSERT INTO `menu` VALUES ('mn30', 'Sinh Tố Sầu Riêng', '', '15', '0');
INSERT INTO `menu` VALUES ('mn31', 'oh', '', '1', '0');
INSERT INTO `menu` VALUES ('MN33', 'Xin chào', '', '140000', '0');
INSERT INTO `menu` VALUES ('MN34', 'L?u Cua ??ng', '', '140000', '0');
INSERT INTO `menu` VALUES ('MN35', 'Sinh T? S?u Riêng', '', '30000', '0');
INSERT INTO `menu` VALUES ('MN36', 'V?t Quay B?c Kinh', '', '145000', '0');
INSERT INTO `menu` VALUES ('mn37', 'V?t Quay B?c Kinh', '', '111', '111');
INSERT INTO `menu` VALUES ('mn38', 'Xin chào m?i', '', '1', '0');
INSERT INTO `menu` VALUES ('mn39', 'Xin chào m?i', '', '1', '0');
INSERT INTO `menu` VALUES ('mn40', 'Xin chào m?i', '', '123', '123');
INSERT INTO `menu` VALUES ('mn50', 'Sinh Tố Sầu Riêng', '', '15', '0');
INSERT INTO `menu` VALUES ('MN51', 'Vịt Quay Bắc Kinh', '', '145000', '0');

-- ----------------------------
-- Table structure for `nhanvien`
-- ----------------------------
DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE `nhanvien` (
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `CauHoiBaoMat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DapAnBaoMat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SinhNhat` date DEFAULT NULL,
  `Sodt` int(11) NOT NULL,
  `Cmnd` int(11) NOT NULL,
  `MaViTri` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaTDVT` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayBatDau` date NOT NULL,
  `TrangPhuc` bit(1) NOT NULL,
  `LuongTheoCa` int(11) NOT NULL,
  `NghiViec` bit(1) NOT NULL,
  PRIMARY KEY (`MaNhanVien`),
  KEY `fk_NV_VT` (`MaViTri`),
  KEY `fk_NV_TDVT` (`MaTDVT`),
  CONSTRAINT `fk_NV_TDVT` FOREIGN KEY (`MaTDVT`) REFERENCES `trinhdovitinh` (`MaTDVT`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_NV_VT` FOREIGN KEY (`MaViTri`) REFERENCES `vitrinhanvien` (`MaViTri`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhanvien
-- ----------------------------
INSERT INTO `nhanvien` VALUES ('NV01', 'nv01nv01', 'Bạn tên gì?', 'Điệp', 'Nguyễn Hữu Điệp', '1993-03-16', '1684001992', '285336953', 'VT01', 'TDVT04', '2016-03-20', '', '0', '');
INSERT INTO `nhanvien` VALUES ('NV02', 'nv02nv02', 'Một cộng một = ?', 'Hai', 'Vương Công Anh Tuấn', '1993-07-14', '123456789', '455678912', 'VT02', 'TDVT03', '2016-03-21', '', '180000', '');
INSERT INTO `nhanvien` VALUES ('NV03', 'nv03nv03', 'Bạn có mê trai không ?', 'Có', 'Phạm Ngọc Duy', '1993-07-15', '124567893', '321645978', 'VT04', 'TDVT01', '2016-03-22', '', '170000', '');
INSERT INTO `nhanvien` VALUES ('NV04', 'nv04nv04', 'Bạn thích gì nhất?', 'Cưỡi ngựa', 'Angela Phương Trinh', '1995-03-08', '164987531', '321564897', 'VT05', 'TDVT02', '2016-03-23', '', '100000', '');
INSERT INTO `nhanvien` VALUES ('NV05', 'nv05nv05', 'Bạn ghét gì nhất?', 'Thổi kèn', 'Ngọc Trinh', '1995-02-07', '1684002345', '123456798', 'VT05', 'TDVT01', '2016-03-23', '', '100000', '');
INSERT INTO `nhanvien` VALUES ('NV06', 'nv06nv06', 'Bạn thích đá banh không?', 'Thích', 'Ưng Hoàng Phúc', '1987-12-10', '12456789', '456780364', 'VT05', 'TDVT03', '2016-03-23', '', '100000', '');
INSERT INTO `nhanvien` VALUES ('NV07', 'nv07nv07', 'Vòng một bạn to không?', 'Siêu to', 'Elly Trần', '1992-10-03', '907123445', '123456987', 'VT03', 'TDVT02', '2016-03-23', '', '120000', '');
INSERT INTO `nhanvien` VALUES ('NV08', 'nv08nv08', 'Bạn thích DJ không?', 'Thích', 'Trang Moon', '1991-07-10', '12023456', '456781236', 'VT06', 'TDVT03', '2016-03-23', '', '120000', '');
INSERT INTO `nhanvien` VALUES ('NV09', 'nv09nv09', 'Bạn thích Nhã Phương không?', 'Ghét', 'Trường Giang', '1987-05-13', '987123456', '323156489', 'VT07', 'TDVT04', '2016-03-23', '', '120000', '');

-- ----------------------------
-- Table structure for `nhanvientheoca`
-- ----------------------------
DROP TABLE IF EXISTS `nhanvientheoca`;
CREATE TABLE `nhanvientheoca` (
  `MaNVTC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaViTri` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuongToiThieu` int(11) DEFAULT NULL,
  `SoLuongToiDa` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaNVTC`),
  KEY `fk_NVTC_VTNV` (`MaViTri`),
  CONSTRAINT `fk_NVTC_VTNV` FOREIGN KEY (`MaViTri`) REFERENCES `vitrinhanvien` (`MaViTri`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhanvientheoca
-- ----------------------------
INSERT INTO `nhanvientheoca` VALUES ('NVTC01', 'VT02', '1', '3');
INSERT INTO `nhanvientheoca` VALUES ('NVTC02', 'VT05', '3', '6');
INSERT INTO `nhanvientheoca` VALUES ('NVTC03', 'VT06', '1', '3');

-- ----------------------------
-- Table structure for `phanquyen`
-- ----------------------------
DROP TABLE IF EXISTS `phanquyen`;
CREATE TABLE `phanquyen` (
  `MaQuyen` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGoi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaQuyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of phanquyen
-- ----------------------------
INSERT INTO `phanquyen` VALUES ('Q01', 'Chủ Nhà Hàng');
INSERT INTO `phanquyen` VALUES ('Q02', 'Quản Lý Nhà Hàng');
INSERT INTO `phanquyen` VALUES ('Q03', 'Nhân Viên Thu Ngân');
INSERT INTO `phanquyen` VALUES ('Q04', 'Nhân Viên Bếp');
INSERT INTO `phanquyen` VALUES ('Q05', 'Nhân Viên');

-- ----------------------------
-- Table structure for `trangthai`
-- ----------------------------
DROP TABLE IF EXISTS `trangthai`;
CREATE TABLE `trangthai` (
  `MaTT` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TTBang` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TenTT` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of trangthai
-- ----------------------------
INSERT INTO `trangthai` VALUES ('TTBG01', 'BanGhe', 'Đang Trống');
INSERT INTO `trangthai` VALUES ('TTBG02', 'BanGhe', 'Có Khách');
INSERT INTO `trangthai` VALUES ('TTBG03', 'BanGhe', 'Đang Đợi Món');
INSERT INTO `trangthai` VALUES ('TTBG04', 'BanGhe', 'Món Đã Xong');
INSERT INTO `trangthai` VALUES ('TTCTM01', 'ChiTietGoiMenu', 'Đang Gọi');
INSERT INTO `trangthai` VALUES ('TTCTM02', 'ChiTietGoiMenu', 'Đang Làm');
INSERT INTO `trangthai` VALUES ('TTCTM03', 'ChiTietMenu', 'Đã Xong');
INSERT INTO `trangthai` VALUES ('TTLLV01', 'LichCaLamViec', 'Có Làm');
INSERT INTO `trangthai` VALUES ('TTLLV02', 'LichCaLamViec', 'Đi Trể');
INSERT INTO `trangthai` VALUES ('TTLLV03', 'LichCaLamViec', 'Vắng Có Phép');
INSERT INTO `trangthai` VALUES ('TTLLV04', 'LichCaLamViec', 'Vắng Không Phép');
INSERT INTO `trangthai` VALUES ('TTLLV05', 'LichCaLamViec', 'Xin Nghỉ Phép');

-- ----------------------------
-- Table structure for `trinhdovitinh`
-- ----------------------------
DROP TABLE IF EXISTS `trinhdovitinh`;
CREATE TABLE `trinhdovitinh` (
  `MaTDVT` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGoi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaTDVT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of trinhdovitinh
-- ----------------------------
INSERT INTO `trinhdovitinh` VALUES ('TDVT01', 'Word');
INSERT INTO `trinhdovitinh` VALUES ('TDVT02', 'Excel');
INSERT INTO `trinhdovitinh` VALUES ('TDVT03', 'Cài Phần Mềm');
INSERT INTO `trinhdovitinh` VALUES ('TDVT04', 'Khác');

-- ----------------------------
-- Table structure for `vitrinhanvien`
-- ----------------------------
DROP TABLE IF EXISTS `vitrinhanvien`;
CREATE TABLE `vitrinhanvien` (
  `MaViTri` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGoi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MaQuyen` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaViTri`),
  KEY `fk_VTNV_PQ` (`MaQuyen`),
  CONSTRAINT `fk_VTNV_PQ` FOREIGN KEY (`MaQuyen`) REFERENCES `phanquyen` (`MaQuyen`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of vitrinhanvien
-- ----------------------------
INSERT INTO `vitrinhanvien` VALUES ('VT01', 'Chủ Nhà Hàng', 'Q01');
INSERT INTO `vitrinhanvien` VALUES ('VT02', 'Quản Lý Nhà Hàng', 'Q02');
INSERT INTO `vitrinhanvien` VALUES ('VT03', 'Nhân Viên Thu Ngân', 'Q03');
INSERT INTO `vitrinhanvien` VALUES ('VT04', 'Nhân Viên Bếp', 'Q04');
INSERT INTO `vitrinhanvien` VALUES ('VT05', 'Nhân Viên Phục Vụ', 'Q05');
INSERT INTO `vitrinhanvien` VALUES ('VT06', 'Nhân Viên Pha Chế', 'Q05');
INSERT INTO `vitrinhanvien` VALUES ('VT07', 'Nhân Viên Tiếp Tân', 'Q05');

-- ----------------------------
-- Procedure structure for `GetAllBanGhe`
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetAllBanGhe`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllBanGhe`()
BEGIN
	select * from BanGhe;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `GetAllMenu`
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetAllMenu`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllMenu`()
BEGIN
	SELECT * FROM menu;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetNhanVien`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetNhanVien`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetNhanVien`()
BEGIN
	select * from Nhanvien;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetNhanVienById`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetNhanVienById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetNhanVienById`(
	idNV varchar(10)
)
BEGIN
	select * from nhanvien where MaNhanVien = idNV;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetNhanVienByIdAndName`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetNhanVienByIdAndName`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetNhanVienByIdAndName`(
	idNV varchar(10),
    nameNV varchar(255)
)
BEGIN
	select * from nhanvien where MaNhanVien = idNV and HoTen = nameNV;
END
;;
DELIMITER ;
