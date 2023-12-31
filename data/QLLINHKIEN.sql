USE [QLLINHKIEN]
GO
/****** Object:  Table [dbo].[ChiTietHD]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChiTietHD](
	[soLuong] [int] NULL,
	[donGia] [float] NULL,
	[maLK] [varchar](20) NULL,
	[soHoaDon] [varchar](20) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[soHoaDon] [varchar](20) NOT NULL,
	[ngayLapHoaDon] [date] NULL,
	[VAT] [float] NULL,
	[hotenKH] [nvarchar](40) NULL,
	[maNV] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[soHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[hotenKH] [nvarchar](40) NOT NULL,
	[soDienThoai] [nvarchar](20) NULL,
	[gioiTinh] [bit] NULL,
	[email] [nvarchar](30) NULL,
	[diemTichLuy] [int] NULL,
	[diaChi] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[hotenKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[maKM] [varchar](20) NOT NULL,
	[tenKM] [nvarchar](30) NOT NULL,
	[moTa] [nvarchar](40) NULL,
	[chietKhau] [float] NULL,
	[ngayBatDau] [date] NULL,
	[ngayKetThuc] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LinhKien]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LinhKien](
	[maLK] [varchar](20) NOT NULL,
	[tenLK] [nvarchar](30) NOT NULL,
	[moTa] [nvarchar](40) NULL,
	[giaNhapVao] [float] NULL,
	[giaBanRa] [float] NULL,
	[soLuongTon] [int] NULL,
	[thoiGianBaoHanh] [int] NULL,
	[xuatXu] [nvarchar](30) NULL,
	[nhaSX] [nvarchar](30) NULL,
	[namSX] [int] NULL,
	[hinhAnh] [nvarchar](30) NULL,
	[mauSac] [nvarchar](20) NULL,
	[maNCC] [varchar](20) NULL,
	[maKM] [varchar](20) NULL,
	[maLoai] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiLinhKien]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiLinhKien](
	[maLoai] [varchar](20) NOT NULL,
	[tenLoai] [nvarchar](30) NOT NULL,
	[tenThuocTinhRieng] [nvarchar](40) NULL,
	[tenGiaTri] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [varchar](20) NOT NULL,
	[tenNCC] [nvarchar](30) NOT NULL,
	[soDienThoai] [nvarchar](20) NULL,
	[email] [nvarchar](30) NULL,
	[Diachi] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](20) NOT NULL,
	[hoNV] [nvarchar](20) NULL,
	[tenNV] [nvarchar](30) NULL,
	[soDienThoai] [nvarchar](20) NULL,
	[namSinh] [int] NULL,
	[gioiTinh] [bit] NULL,
	[email] [nvarchar](30) NULL,
	[diaChi] [nvarchar](40) NULL,
	[chucVu] [nvarchar](25) NULL,
	[tenTK] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/9/2023 3:20:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTK] [nvarchar](30) NOT NULL,
	[matKhauTK] [nvarchar](30) NOT NULL,
	[loaiTK] [nvarchar](30) NULL,
	[ngayTaoTK] [date] NULL,
	[trangThaiTK] [bit] NULL,
	[email] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[tenTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[KhachHang] ([hotenKH], [soDienThoai], [gioiTinh], [email], [diemTichLuy], [diaChi]) VALUES (N'Le Minh Quan', N'0934724421', 1, N'zxgfawca@gmail.com', 900000, N'87 Nguyen Du')
INSERT [dbo].[KhachHang] ([hotenKH], [soDienThoai], [gioiTinh], [email], [diemTichLuy], [diaChi]) VALUES (N'Le Phuoc Thai', N'0354724414', 1, N'acczxca@gmail.com', 110000, N'16 Ngo Tat To')
INSERT [dbo].[KhachHang] ([hotenKH], [soDienThoai], [gioiTinh], [email], [diemTichLuy], [diaChi]) VALUES (N'Nguyen Minh Phuc', N'0914724414', 1, N'bzxcaxca@gmail.com', 70000, N'18 Truong Sa')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [email], [Diachi]) VALUES (N'NCC01', N'FPT', N'0354724412', N'phongvu@gmail.com', N'24 Mac Thi Buoi')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [email], [Diachi]) VALUES (N'NCC02', N'GearVN', N'0949724414', N'GearVN@gmail.com', N'25 Nguyen Du')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [email], [Diachi]) VALUES (N'NCC03', N'An Phat PC', N'0919460898', N'AnPhat@gmail.com', N'1A Ben Nghe')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [soDienThoai], [email], [Diachi]) VALUES (N'NCC04', N'Minh Anh Store', N'0949076898', N'tggd@gmail.com', N'78 Pastuer Q1')
INSERT [dbo].[NhanVien] ([maNV], [hoNV], [tenNV], [soDienThoai], [namSinh], [gioiTinh], [email], [diaChi], [chucVu], [tenTK]) VALUES (N'NV001', N'Le', N'Van A', N'0919460838', 2003, 1, N'abcxyz@gmail.com', N'12 Nguyen Van Bao', N'Nhan vien', N'LeVanA123')
INSERT [dbo].[NhanVien] ([maNV], [hoNV], [tenNV], [soDienThoai], [namSinh], [gioiTinh], [email], [diaChi], [chucVu], [tenTK]) VALUES (N'NV002', N'Nguyen', N'Van B', N'0949460853', 2002, 1, N'aaacxyz@gmail.com', N'25 Nguyen Du', N'Nhan vien', N'NguyenVanB123')
INSERT [dbo].[NhanVien] ([maNV], [hoNV], [tenNV], [soDienThoai], [namSinh], [gioiTinh], [email], [diaChi], [chucVu], [tenTK]) VALUES (N'NV003', N'Tran', N'Thi C', N'0349460853', 2001, 0, N'bbbcxyz@gmail.com', N'18 Nguyen Du', N'Nhan vien', N'TranThiC123')
INSERT [dbo].[TaiKhoan] ([tenTK], [matKhauTK], [loaiTK], [ngayTaoTK], [trangThaiTK], [email]) VALUES (N'LeVanA123', N'az123456', N'nhanvien', CAST(N'2021-11-10' AS Date), 1, N'abcxyz@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenTK], [matKhauTK], [loaiTK], [ngayTaoTK], [trangThaiTK], [email]) VALUES (N'NguyenVanB123', N'abzcasczx', N'nhanvien', CAST(N'2021-10-05' AS Date), 1, N'aaacxyz@gmail.com')
INSERT [dbo].[TaiKhoan] ([tenTK], [matKhauTK], [loaiTK], [ngayTaoTK], [trangThaiTK], [email]) VALUES (N'TranThiC123', N'bbzcasczx', N'nhanvien', CAST(N'2021-08-01' AS Date), 1, N'bbbcxyz@gmail.com')
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__KhuyenMa__FB74C15012417F3B]    Script Date: 11/9/2023 3:20:13 PM ******/
ALTER TABLE [dbo].[KhuyenMai] ADD UNIQUE NONCLUSTERED 
(
	[tenKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__LinhKien__FB74D8FC61D7DBA5]    Script Date: 11/9/2023 3:20:13 PM ******/
ALTER TABLE [dbo].[LinhKien] ADD UNIQUE NONCLUSTERED 
(
	[tenLK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__LoaiLinh__CA1FBB5FAFD26149]    Script Date: 11/9/2023 3:20:13 PM ******/
ALTER TABLE [dbo].[LoaiLinhKien] ADD UNIQUE NONCLUSTERED 
(
	[tenLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__NhaCungC__AFCF872A54B4C1C6]    Script Date: 11/9/2023 3:20:13 PM ******/
ALTER TABLE [dbo].[NhaCungCap] ADD UNIQUE NONCLUSTERED 
(
	[tenNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__TaiKhoan__7711F13486FFC405]    Script Date: 11/9/2023 3:20:13 PM ******/
ALTER TABLE [dbo].[TaiKhoan] ADD UNIQUE NONCLUSTERED 
(
	[matKhauTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD FOREIGN KEY([maLK])
REFERENCES [dbo].[LinhKien] ([maLK])
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD FOREIGN KEY([soHoaDon])
REFERENCES [dbo].[HoaDon] ([soHoaDon])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([hotenKH])
REFERENCES [dbo].[KhachHang] ([hotenKH])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD FOREIGN KEY([maKM])
REFERENCES [dbo].[KhuyenMai] ([maKM])
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD FOREIGN KEY([maLoai])
REFERENCES [dbo].[LoaiLinhKien] ([maLoai])
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([tenTK])
REFERENCES [dbo].[TaiKhoan] ([tenTK])
GO
