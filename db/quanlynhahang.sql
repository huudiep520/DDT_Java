/*
Navicat MySQL Data Transfer

Source Server         : Connect-Ecommerce
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : quanlynhahang

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-04-25 18:01:22
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
  `xoa` varchar(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`MaBan`),
  KEY `fk_BG_NV` (`MaNhanVienTruc`),
  KEY `fk_BG_TT` (`MaTrangThai`),
  CONSTRAINT `fk_BG_NV` FOREIGN KEY (`MaNhanVienTruc`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_BG_TT` FOREIGN KEY (`MaTrangThai`) REFERENCES `trangthai` (`MaTT`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_dyveoyxqbsrqjv2l425pts8jv` FOREIGN KEY (`MaNhanVienTruc`) REFERENCES `nhanvien` (`MaNhanVien`),
  CONSTRAINT `FK_q2qsd9f9b2mjl3nk2frbld0qa` FOREIGN KEY (`MaTrangThai`) REFERENCES `trangthai` (`MaTT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of banghe
-- ----------------------------
INSERT INTO `banghe` VALUES ('A1', null, '0', '4', 'TTBG03', '0');
INSERT INTO `banghe` VALUES ('A2', null, '0', '2', 'TTBG01', '0');
INSERT INTO `banghe` VALUES ('A3', 'NV04', '0', '4', 'TTBG01', '0');
INSERT INTO `banghe` VALUES ('A4', null, '0', '6', 'TTBG01', '0');
INSERT INTO `banghe` VALUES ('A5', null, '0', '4', 'TTBG01', '0');
INSERT INTO `banghe` VALUES ('A6', null, '0', '4', 'TTBG01', '0');
INSERT INTO `banghe` VALUES ('B1', null, '0', '2', 'TTBG01', '0');
INSERT INTO `banghe` VALUES ('B2', null, '0', '4', 'TTBG02', '0');
INSERT INTO `banghe` VALUES ('B3', null, '0', '4', 'TTBG03', '0');
INSERT INTO `banghe` VALUES ('B4', null, '0', '6', 'TTBG04', '0');
INSERT INTO `banghe` VALUES ('B5', null, '2', '2', 'TTBG04', '0');
INSERT INTO `banghe` VALUES ('B6', null, '0', '4', 'TTBG01', '0');

-- ----------------------------
-- Table structure for `bangluong`
-- ----------------------------
DROP TABLE IF EXISTS `bangluong`;
CREATE TABLE `bangluong` (
  `MaLuong` int(11) NOT NULL AUTO_INCREMENT,
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayGioNhan` datetime NOT NULL,
  `TongCaLam` int(11) NOT NULL,
  `VangCoPhep` int(11) DEFAULT NULL,
  `VangKhongPhep` int(11) DEFAULT NULL,
  `ThoiGianTre` int(11) DEFAULT NULL,
  `TongLuong` int(11) NOT NULL,
  PRIMARY KEY (`MaLuong`),
  KEY `FK_c43x2bc95xr4189rssavkesqx` (`MaNhanVien`),
  CONSTRAINT `FK_c43x2bc95xr4189rssavkesqx` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`)
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
  `MaCTG` int(11) NOT NULL AUTO_INCREMENT,
  `MaBan` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaMenu` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGoi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuongGoi` int(11) NOT NULL,
  `GhiChu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ThoiGianGoi` time NOT NULL,
  `MaTrangThai` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaCTG`),
  KEY `FK_t4y3589rwpsv7leu8re8i39ap` (`MaBan`),
  KEY `FK_cafmffi2esgue53knm1pnmjmd` (`MaMenu`),
  KEY `FK_sexim4h2ykb4fu9143og99p4w` (`MaTrangThai`),
  CONSTRAINT `FK_cafmffi2esgue53knm1pnmjmd` FOREIGN KEY (`MaMenu`) REFERENCES `menu` (`MaMenu`),
  CONSTRAINT `FK_sexim4h2ykb4fu9143og99p4w` FOREIGN KEY (`MaTrangThai`) REFERENCES `trangthai` (`MaTT`),
  CONSTRAINT `FK_t4y3589rwpsv7leu8re8i39ap` FOREIGN KEY (`MaBan`) REFERENCES `banghe` (`MaBan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitietgoimenu
-- ----------------------------

-- ----------------------------
-- Table structure for `chitiethoadon`
-- ----------------------------
DROP TABLE IF EXISTS `chitiethoadon`;
CREATE TABLE `chitiethoadon` (
  `MaCTHD` int(11) NOT NULL AUTO_INCREMENT,
  `MaHD` int(11) NOT NULL,
  `MaMenu` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenGoi` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL,
  PRIMARY KEY (`MaCTHD`),
  KEY `FK_drimu40nfjst5si8utgdq2r48` (`MaHD`),
  KEY `FK_l2dhch3owj625awetnytmdq6i` (`MaMenu`),
  CONSTRAINT `FK_drimu40nfjst5si8utgdq2r48` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  CONSTRAINT `FK_l2dhch3owj625awetnytmdq6i` FOREIGN KEY (`MaMenu`) REFERENCES `menu` (`MaMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of chitiethoadon
-- ----------------------------

-- ----------------------------
-- Table structure for `hoadon`
-- ----------------------------
DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE `hoadon` (
  `MaHD` int(11) NOT NULL AUTO_INCREMENT,
  `MaBan` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenKhachHang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenNhanVien` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SoLuongKhach` int(11) NOT NULL,
  `NgayGio` datetime NOT NULL,
  `TongTien` int(11) NOT NULL,
  `ThanhToan` bit(1) NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `FK_82k5tmkfpxo6dygxcr2d6miw6` (`MaBan`),
  KEY `FK_hvekqwdihjcthloqyh3xb44ip` (`MaNhanVien`),
  CONSTRAINT `FK_82k5tmkfpxo6dygxcr2d6miw6` FOREIGN KEY (`MaBan`) REFERENCES `banghe` (`MaBan`),
  CONSTRAINT `FK_hvekqwdihjcthloqyh3xb44ip` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of hoadon
-- ----------------------------

-- ----------------------------
-- Table structure for `lichcalamviec`
-- ----------------------------
DROP TABLE IF EXISTS `lichcalamviec`;
CREATE TABLE `lichcalamviec` (
  `MaLich` int(11) NOT NULL AUTO_INCREMENT,
  `MaCa` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNhanVien` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaTrangThai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ThoiGian` date NOT NULL,
  `ThoiGianTre` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaLich`),
  KEY `FK_6fwk2iaqnmchl2crkck7d89n5` (`MaCa`),
  KEY `FK_ksk6p3ojuuokbsmaa5t1tqgsr` (`MaNhanVien`),
  KEY `FK_dcns4hay0w0f73xf04dtmnu0w` (`MaTrangThai`),
  CONSTRAINT `FK_6fwk2iaqnmchl2crkck7d89n5` FOREIGN KEY (`MaCa`) REFERENCES `calamviec` (`MaCa`),
  CONSTRAINT `FK_dcns4hay0w0f73xf04dtmnu0w` FOREIGN KEY (`MaTrangThai`) REFERENCES `trangthai` (`MaTT`),
  CONSTRAINT `FK_ksk6p3ojuuokbsmaa5t1tqgsr` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`)
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
  `KhuyenMai` float NOT NULL,
  PRIMARY KEY (`MaMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------

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
  CONSTRAINT `FK_9uqk46movrc2qg959nua6ehlf` FOREIGN KEY (`MaTDVT`) REFERENCES `trinhdovitinh` (`MaTDVT`),
  CONSTRAINT `FK_l9sr6y2n5bhscxbpuq8bpy5oh` FOREIGN KEY (`MaViTri`) REFERENCES `vitrinhanvien` (`MaViTri`),
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
  KEY `FK_1g30nebb21v0tjv7unkph6bm` (`MaViTri`),
  CONSTRAINT `FK_1g30nebb21v0tjv7unkph6bm` FOREIGN KEY (`MaViTri`) REFERENCES `vitrinhanvien` (`MaViTri`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhanvientheoca
-- ----------------------------

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
  CONSTRAINT `FK_3lbb3w0nhmj5uqvgj1ykcymxb` FOREIGN KEY (`MaQuyen`) REFERENCES `phanquyen` (`MaQuyen`),
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
-- Procedure structure for `sp_CheckLogin`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_CheckLogin`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_CheckLogin`(
	maNV varchar(10),
    mkNV varchar(16)
)
BEGIN
	select * from nhanvien where MaNhanVien = maNV and MatKhau = mkNV;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetBanGhe`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetBanGhe`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetBanGhe`()
BEGIN
	select * from banghe bg where bg.xoa = 0 order by bg.MaBan asc;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetBanGheById`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetBanGheById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetBanGheById`(
	maBan varchar(10)
)
BEGIN
	select bg.* from banghe bg where bg.MaBan = maBan;
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
	select * from nhanvien nv where nv.MaNhanVien = idNV;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetPermission`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetPermission`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetPermission`(
	maNV varchar(10),
    mkNV varchar(16)
)
BEGIN
	select pq.* from nhanvien nv, vitrinhanvien vtnv, phanquyen pq
    where nv.MaViTri = vtnv.MaViTri and vtnv.MaQuyen = pq.MaQuyen and nv.MaNhanVien = maNV and nv.MatKhau = mkNV;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_GetTrangThaiBanGhe`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_GetTrangThaiBanGhe`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetTrangThaiBanGhe`()
BEGIN
	select * from trangthai where MaTT like '%TTBG%';
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_UpdateSoLuongKhach`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_UpdateSoLuongKhach`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_UpdateSoLuongKhach`(
	soLuongKH int,
    idTab varchar(10)
)
BEGIN
	update banghe bg set bg.SoLuongKhach = soLuongKH where bg.MaBan = idTab;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_UpdateStatusTable`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_UpdateStatusTable`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_UpdateStatusTable`(
	idST varchar(10),
    idTab varchar(10)
)
BEGIN
	if idST='1' then
			UPDATE banghe set MaTrangThai = 'TTBG01' where MaBan = idTab; /*bàn trống*/
		elseif idST='2' then
			UPDATE banghe set MaTrangThai = 'TTBG02' where MaBan = idTab; /*bàn có khách*/
		elseif idST='3' then
			UPDATE banghe set MaTrangThai = 'TTBG03' where MaBan = idTab; /*đang đợi món*/
		elseif idST='4' then
			UPDATE banghe set MaTrangThai = 'TTBG04' where MaBan = idTab; /*món đã đủ*/
    end if;
    /*select * from banghe bg where bg.MaBan = idTab;*/
    /*update banghe set MaTrangThai = 'TTBG01' where MaBan = idTab; bàn trống*/
END
;;
DELIMITER ;
