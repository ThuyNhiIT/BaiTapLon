package entity;

import java.util.Objects;

public class TaiKhoan {

    private NhanVien username;
    private String passWord;

    public TaiKhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TaiKhoan(NhanVien username) {
        this.username = username;
    }
    
    public TaiKhoan(NhanVien username, String passWord) {
        super();
        this.username = username;
        this.passWord = passWord;
    }

    public NhanVien getUsername() {
        return username;
    }

    public void setUsername(NhanVien username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) throws Exception {
        if (passWord.trim().isEmpty()) {
            throw new Exception("Password không được rỗng!");
        } else if (passWord.length() < 8) {
            throw new Exception("Password tối thiểu 8 kí tự!");
        } else if (!passWord.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$")) {
            throw new Exception("Phải có cả chữ, số và có ít nhất 1 chữ in hoa!");
        } else {
            this.passWord = passWord;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaiKhoan other = (TaiKhoan) obj;
        return Objects.equals(this.username, other.username);
    }


    @Override
    public String toString() {
        return "TaiKhoan [username=" + username + ", passWord=" + passWord + "]";
    }

    public void setUsername(String maNV) {
       
    }

}
