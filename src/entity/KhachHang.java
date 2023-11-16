package entity;

public class KhachHang {
	private String hoTenKH;
	private String soDienThoai;
	private String gioiTinh;
	private String email;
	private int diemTichLuy;
	private String diaChi;
	public KhachHang(String hoTenKH, String soDienThoai, String gioiTinh, String email, int diemTichLuy,
			String diaChi) {
		super();
		this.hoTenKH = hoTenKH;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.diemTichLuy = diemTichLuy;
		this.diaChi = diaChi;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "KhachHang [hoTenKH=" + hoTenKH + ", soDienThoai=" + soDienThoai + ", gioiTinh=" + gioiTinh + ", email="
				+ email + ", diemTichLuy=" + diemTichLuy + ", diaChi=" + diaChi + "]";
	}
	
	
	

}
