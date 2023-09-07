# quanlybanhangV2
đề bài(đăng nhập admin admin file nv trong nhanvien.txt)
X Y DỰNG HỆ THỐNG QUẢN LÝ BÁN HÀNG
PHẦN I
Đối tượng Khách hàng bao gồm các thông tin: Mã khách hàng, Tên khách hàng, số điện thoại, email, địa chỉ
Đối tượng Nhân viên bao gồm các thông tin: Mã nhân viên, Tên nhân viên, số điện thoại, email, mật khẩu, địa chỉ, giới tính, nhóm, trạng thái
Đối tượng Sản phẩm bao gồm các thông tin: Mã sản phẩm, tên sản phẩm, số lượng, đơn giá
Các chức năng chính của chương trình:
Đăng nhập: Dựa vào mã nhân viên và mật khẩu để cho phép nhân viên đăng nhập vào chương trình. Đăng nhập thành công mới hiển thị giao diện chính của chương trình.
Main: Có menu quay vòng đến khi người dùng chọn thoát thì thoát khỏi chương trình.
Quản lý thông tin khách hàng:
Xem danh sách toàn bộ khách hàng
Tìm kiếm khách hàng theo mã khách hàng, số điện thoại, email
Thêm mới một khách hàng: yêu cầu kiểm tra không được trùng mã khách hàng, kiểm tra thông tin nhập vào: tên không chứa số, số điện thoại >= 10 chữ số và <=11 chữ số, email phải đúng định dạng xxx@abc.com
Sửa thông tin khách hàng: Cập nhật thông tin khách hàng, không cho phép sửa mã khách hàng. và kiểm tra thông tin nhập vào: tên không chứa số, số điện thoại >= 10 chữ số và <=11 chữ số, email phải đúng định dạng xxx@abc.com
Xóa thông tin khách hàng: Nhập vào mã khách hàng và xóa khách hàng đó khỏi danh sách khách hàng.
Quản lý thông tin nhân viên:
Xem danh sách toàn bộ nhân viên
Tìm kiếm nhân viên theo mã nhân viên, số điện thoại, email
Thêm mới một nhân viên: yêu cầu kiểm tra không được trùng mã nhân viên, kiểm tra thông tin nhập vào: tên không chứa số, số điện thoại >= 10 chữ số và <=11 chữ số, email phải đúng định dạng xxx@abc.com. Mật khẩu có thể nên mã hóa md5 để tránh lưu dạng bản rõ vào file.
Sửa thông tin nhân viên: Cập nhật thông tin nhân viên, không cho phép sửa mã nhân viên. và kiểm tra thông tin nhập vào: tên không chứa số, số điện thoại >= 10 chữ số và <=11 chữ số, email phải đúng định dạng xxx@abc.com
Xóa thông tin nhân viên: Nhập vào mã nhân viên và xóa nhân viên đó khỏi danh sách nhân viên.
Quản lý thông tin sản phẩm:
Xem danh sách toàn bộ sản phẩm
Tìm kiếm sản phẩm theo mã sản phẩm
Thêm mới một sản phẩm: yêu cầu kiểm tra không được trùng mã sản phẩm, kiểm tra thông tin nhập vào: số lượng và đơn giá phải là số lớn hơn 0
Sửa thông tin sản phẩm: yêu cầu kiểm tra không được trùng mã sản phẩm, kiểm tra thông tin nhập vào: số lượng và đơn giá phải là số lớn hơn 0
Xóa thông tin sản phẩm: Nhập vào mã sản phẩm và xóa sản phẩm đó khỏi danh sách sản phẩm.
Chú ý: Dữ liệu được lưu trên các file khác nhau: khachhang.txt, nhanvien.txt, sanpham.txt
PHẦN II
Xây dựng chức năng quản lý bán hàng để lưu lại thông tin bán hàng.
- Đối tượng hóa đơn bao gồm: mã khách hàng, mã nhân viên, mã sản phẩm, số lượng mua, đơn giá, thành tiền, ngày bán
Quản lý bán hàng:  Thêm mới hóa đơn bán hàng: sử dụng khi có khách hàng mua hàng
Quy trình bán hàng: khi có khách hàng mua hàng 
Bước 1: Chọn chức năng bán hàng (khởi tạo array list giỏ hàng để lưu sản phẩm mua)
Bước 2: Nhập mã khách hàng, kiểm tra xem có khách hàng có trong danh sách chưa ? Nếu có rồi thì load thông tin khách hàng ra hiển thị cho nhân viên, còn chưa có thì tiến thành thêm mới thông tin khách hàng. Sau khi thêm mới xong tự động quay lại chức năng bán hàng.
Bước 3: Nhập mã sản phẩm: tìm thông tin sản phẩm và hiển thị ra màn hình, nếu chưa có thì thông báo còn nếu có thì cho nhập vào số lượng mua
Bước 4: Sau khi nhập số lượng mua, kiểm tra xem có thỏa mã >0 và nhỏ hơn số lượng có trong kho, nếu thỏa mã thì thêm sản phẩm vào giỏ hàng ( array list giỏ hàng)
Bước 5: Chọn tiếp tục mua hàng hoặc thanh toán:
Bước 5.1: Chọn tiếp tục mua hàng, thì quay trở lại Bước 3
Bước 5.2: Chọn thanh toán -> hiển thị ra thông tin hóa đơn dạng:
     |    STT    |     Mã sản phẩm      |      Tên sản phẩm     |     Số lượng mua    | Đơn giá | Thành tiền |  Tổng tiền | 
Và lưu thông tin đơn hàng vào file hoadon.txt.
Báo cáo thống kê
Xem danh sách hóa đơn đã bán trong trong 1 ngày: nhập vào 1 ngày và xem toàn bộ danh sách hóa đơn đã bán và tổng số tiền bán trong ngày đó. Có thể thêm chức năng xuất ra file báo cáo.
Xem danh sách hóa đơn đã bán trong tháng: nhập vào 1 tháng  và xem toàn bộ danh sách hóa đơn đã bán và tổng số tiền bán trong tháng đó. Có thể thêm chức năng xuất ra file báo cáo.
Xem doanh thu theo nhân viên trong tháng: mỗi nhân viên bán được tổng số bao nhiêu tiền trong tháng. Có thể thêm chức năng xuất ra file báo cáo.
Xem Danh sách các sản phẩm có số lượng < 10 (sắp hết hàng để nhập thêm hàng) Có thể thêm chức năng xuất ra file báo cáo.
Xem Danh sách các sản phẩm có số lượng > 100 (tồn nhiều hàng ) Có thể thêm chức năng xuất ra file báo cáo.

