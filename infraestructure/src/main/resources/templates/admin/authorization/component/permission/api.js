function fetchPermissions() {
    const data = [
      {
        function: 'product:search',
        group: ['Admin', 'Khách hàng', 'Nhân viên kinh doanh', 'Nhân viên kho'],
        status: 'Active',
        description: 'Chức năng tìm kiếm sản phẩm',
        id: 1,
      },
      {
        function: 'product:search',
        group: ['Admin', 'Khách hàng', 'Nhân viên kinh doanh', 'Nhân viên kho'],
        status: 'Active',
        description: 'Chức năng tìm kiếm sản phẩm',
        id: 2,
      },
    ];
    return data;
}