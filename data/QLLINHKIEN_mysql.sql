-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: QLLINHKIEN
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ChiTietHD`
--

DROP TABLE IF EXISTS `ChiTietHD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ChiTietHD` (
  `soLuong` int DEFAULT NULL,
  `donGia` float DEFAULT NULL,
  `maLK` varchar(20) DEFAULT NULL,
  `soHoaDon` varchar(20) DEFAULT NULL,
  KEY `maLK` (`maLK`),
  KEY `soHoaDon` (`soHoaDon`),
  CONSTRAINT `chitiethd_ibfk_1` FOREIGN KEY (`maLK`) REFERENCES `LinhKien` (`maLK`),
  CONSTRAINT `chitiethd_ibfk_2` FOREIGN KEY (`soHoaDon`) REFERENCES `HoaDon` (`soHoaDon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `HoaDon`
--

DROP TABLE IF EXISTS `HoaDon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HoaDon` (
  `soHoaDon` varchar(20) NOT NULL,
  `ngayLapHoaDon` date DEFAULT NULL,
  `VAT` float DEFAULT NULL,
  `hotenKH` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `maNV` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`soHoaDon`),
  KEY `hotenKH` (`hotenKH`),
  KEY `maNV` (`maNV`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`hotenKH`) REFERENCES `KhachHang` (`hotenKH`),
  CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`maNV`) REFERENCES `NhanVien` (`maNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `KhachHang`
--

DROP TABLE IF EXISTS `KhachHang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KhachHang` (
  `hotenKH` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `soDienThoai` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gioiTinh` bit(1) DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diemTichLuy` int DEFAULT NULL,
  `diaChi` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`hotenKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `KhuyenMai`
--

DROP TABLE IF EXISTS `KhuyenMai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KhuyenMai` (
  `maKM` varchar(20) NOT NULL,
  `tenKM` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `moTa` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `chietKhau` float DEFAULT NULL,
  `ngayBatDau` date DEFAULT NULL,
  `ngayKetThuc` date DEFAULT NULL,
  PRIMARY KEY (`maKM`),
  UNIQUE KEY `UQ_KhuyenMai_tenKM` (`tenKM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `LinhKien`
--

DROP TABLE IF EXISTS `LinhKien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LinhKien` (
  `maLK` varchar(20) NOT NULL,
  `tenLK` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `moTa` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `giaNhapVao` float DEFAULT NULL,
  `giaBanRa` float DEFAULT NULL,
  `soLuongTon` int DEFAULT NULL,
  `thoiGianBaoHanh` int DEFAULT NULL,
  `xuatXu` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nhaSX` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `namSX` int DEFAULT NULL,
  `hinhAnh` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mauSac` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `maNCC` varchar(20) DEFAULT NULL,
  `maKM` varchar(20) DEFAULT NULL,
  `maLoai` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`maLK`),
  KEY `maKM` (`maKM`),
  KEY `maLoai` (`maLoai`),
  KEY `maNCC` (`maNCC`),
  CONSTRAINT `linhkien_ibfk_1` FOREIGN KEY (`maKM`) REFERENCES `KhuyenMai` (`maKM`),
  CONSTRAINT `linhkien_ibfk_2` FOREIGN KEY (`maLoai`) REFERENCES `LoaiLinhKien` (`maLoai`),
  CONSTRAINT `linhkien_ibfk_3` FOREIGN KEY (`maNCC`) REFERENCES `NhaCungCap` (`maNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `LoaiLinhKien`
--

DROP TABLE IF EXISTS `LoaiLinhKien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LoaiLinhKien` (
  `maLoai` varchar(20) NOT NULL,
  `tenLoai` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tenThuocTinhRieng` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenGiaTri` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maLoai`),
  UNIQUE KEY `UQ_LoaiLinhKien_tenLoai` (`tenLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NhaCungCap`
--

DROP TABLE IF EXISTS `NhaCungCap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NhaCungCap` (
  `maNCC` varchar(20) NOT NULL,
  `tenNCC` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `soDienThoai` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Diachi` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maNCC`),
  UNIQUE KEY `UQ_NhaCungCap_tenNCC` (`tenNCC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `NhanVien`
--

DROP TABLE IF EXISTS `NhanVien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NhanVien` (
  `maNV` varchar(20) NOT NULL,
  `hoNV` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenNV` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `soDienThoai` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `namSinh` int DEFAULT NULL,
  `gioiTinh` bit(1) DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `diaChi` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `chucVu` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tenTK` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`maNV`),
  KEY `tenTK` (`tenTK`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`tenTK`) REFERENCES `TaiKhoan` (`tenTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TaiKhoan`
--

DROP TABLE IF EXISTS `TaiKhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TaiKhoan` (
  `tenTK` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `matKhauTK` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `loaiTK` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ngayTaoTK` date DEFAULT NULL,
  `trangThaiTK` bit(1) DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`tenTK`),
  UNIQUE KEY `UQ_TaiKhoan_matKhauTK` (`matKhauTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'QLLINHKIEN'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-16 10:38:01
