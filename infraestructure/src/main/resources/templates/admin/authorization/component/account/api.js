function fetchAccounts() {
    const data = [
      {
        name: 'Phan Hoàng Kha',
        username: 'phanhoangkha',
        phone: '0329199948',
        email: 'phanhoangkha01@gmail.com',
        group: [
                  {
                    "id": "1",
                    "name": "ADMIN",
                    "desc": "Quản trị hệ thống",
                    "active": true
                  },
                  {
                    "id": "3",
                    "name": "Nhân viên bán hàng",
                    "desc": "Quản trị hệ thống",
                      "active": true
                  },
                  {
                    "id": "9",
                    "name": "ADMIN",
                    "desc": "Quản trị hệ thống",
                     "active": false
                  }
                ],
        status: 'Active',
        id: 1,
      },
      {
              name: 'Phan Hoàng Kha',
              username: 'phanhoangkha',
              phone: '0329199948',
              email: 'phanhoangkha01@gmail.com',
              group: [
                           {
                             "id": "1",
                             "name": "ADMIN",
                             "desc": "Quản trị hệ thống",
                             "active": true
                           },
                           {
                             "id": "3",
                             "name": "Nhân viên bán hàng",
                             "desc": "Quản trị hệ thống",
                               "active": true
                           },
                           {
                             "id": "9",
                             "name": "ADMIN",
                             "desc": "Quản trị hệ thống",
                              "active": false
                           }
                         ],
                 status: 'Active',
              id: 2,
            },
    ];
    return data;
}

function fetchAccountById(id) {
    const data = [
                   {
                     "name": "Phan Hoàng Kha",
                     "username": "phanhoangkha",
                     "phone": "0329199948",
                     "email": "phanhoangkha01@gmail.com",
                     "group": [
                       {
                         "id": "1",
                         "name": "ADMIN",
                         "desc": "Quản trị hệ thống"
                       },
                       {
                         "id": "1",
                         "name": "ADMIN",
                         "desc": "Quản trị hệ thống"
                       },
                       {
                         "id": "1",
                         "name": "ADMIN",
                         "desc": "Quản trị hệ thống"
                       },
                       {
                         "id": "1",
                         "name": "ADMIN",
                         "desc": "Quản trị hệ thống"
                       }
                     ],
                     "status": "Active",
                     "id": 1
                   }
                 ];
    return data;
}