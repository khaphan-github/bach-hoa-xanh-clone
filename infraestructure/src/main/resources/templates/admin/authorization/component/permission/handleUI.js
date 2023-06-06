
function renderPermissionTable() {
  const data = fetchPermissions();

  const tableBody = document.querySelector('#authorization-permission-data-table tbody');

  // Clear existing table data
  tableBody.innerHTML = '';

  data.forEach((item) => {
    const row = document.createElement('tr');

    const functionCell = document.createElement('td');
    functionCell.innerHTML = `<strong>${item.function}</strong>`;
    row.appendChild(functionCell);

    const groupCell = document.createElement('td');
    const groupBadges = item.group.map((group) => `<span class="badge bg-label-primary me-1">${group}</span>`);
    groupCell.innerHTML = groupBadges.join('');
    row.appendChild(groupCell);

    const statusCell = document.createElement('td');
    statusCell.innerHTML = `<span class="badge bg-label-primary me-1">${item.status}</span>`;
    row.appendChild(statusCell);

    const descriptionCell = document.createElement('td');
    descriptionCell.textContent = item.description;
    row.appendChild(descriptionCell);

    const actionsCell = document.createElement('td');
    const viewButton = document.createElement('button');

    viewButton.setAttribute('type', 'button');
    viewButton.setAttribute('class', 'btn btn-sm btn-primary');
    viewButton.setAttribute('data-bs-toggle', 'modal');
    viewButton.setAttribute('data-bs-target', '#exLargeModal');
    viewButton.textContent = 'Xem chi tiết';

    actionsCell.appendChild(viewButton);
    row.appendChild(actionsCell);

    // Append the row to the table body
    tableBody.appendChild(row);
  });
}
