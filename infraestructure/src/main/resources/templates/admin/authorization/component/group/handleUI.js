
function renderGroupPermissionTable() {
  const data = fetchGroupPermission();

  const tableBody = document.querySelector('#authorization-group-data-table tbody');

  tableBody.innerHTML = '';

  data.forEach((item) => {
    const row = document.createElement('tr');

    const groupCell = document.createElement('td');
    groupCell.innerHTML = `<strong>${item.group}</strong>`;
    row.appendChild(groupCell);

    const descriptionCell = document.createElement('td');
    descriptionCell.textContent = item.description;
    row.appendChild(descriptionCell);

    const statusCell = document.createElement('td');
    statusCell.innerHTML = `<span class="badge bg-label-primary me-1">${item.status}</span>`;
    row.appendChild(statusCell);

    const actionsCell = document.createElement('td');
    const viewButton = document.createElement('button');

    viewButton.setAttribute('type', 'button');
    viewButton.setAttribute('class', 'btn btn-sm btn-primary');
    viewButton.setAttribute('data-bs-toggle', 'modal');
    viewButton.setAttribute('data-bs-target', '#exLargeModal');
    viewButton.textContent = 'Xem chi tiết';
    viewButton.addEventListener('click', () => {
         toggleActivation(statusButton);

         const status = statusButton.textContent;
         handleSelectionGroup(selectedIds, group.id, statusButton.textContent);

         callback(selectedIds);
       });

    actionsCell.appendChild(viewButton);
    row.appendChild(actionsCell);

    tableBody.appendChild(row);
  });
}
