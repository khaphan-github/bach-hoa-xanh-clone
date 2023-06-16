function openEditPopup(element) {
  var storageId = element.getAttribute('data-storage-id');

  // Lấy thông tin từ storageId và thực hiện các hành động cần thiết, ví dụ:
  var storageAddress = element.closest('tr').querySelector('td:nth-child(1)').innerText;
  var storageName = element.closest('tr').querySelector('td:nth-child(2)').innerText;

  // Đặt thông tin vào các trường trong popup
  document.getElementById('storage-id').value = storageId;
  document.getElementById('storage-address').value = storageAddress;
  document.getElementById('storage-name').value = storageName;

  // Hiển thị popup
  $('#editStorageModal').modal('show');
}
