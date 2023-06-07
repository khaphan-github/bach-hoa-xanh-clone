function fetchPermissions() {
    const data = [
      {
        function: 'product:search',
        group: [{
                                 "id": "1",
                                 "name": "ADMIN",
                                 "desc": "Quản trị hệ thống",
                                 "active": true,
                               },
                               {
                                 "id": "2",
                                 "name": "Nhân viên bán hàng",
                                 "desc": "Nhân viên bán hàng",
                                 "active": true,
                               }],
        active: true,
        description: 'Chức năng tìm kiếm sản phẩm',
        id: 1,
      },
      {
        function: 'product:search',
        group: [{
                                 "id": "1",
                                 "name": "ADMIN",
                                 "desc": "Quản trị hệ thống",
                                 "active": true,
                               },
                               {
                                 "id": "2",
                                 "name": "Nhân viên bán hàng",
                                 "desc": "Nhân viên bán hàng",
                                 "active": true,
                               }],
        active: true,
        description: 'Chức năng tìm kiếm sản phẩm',
        id: 2,
      },
    ];
    return data;
}