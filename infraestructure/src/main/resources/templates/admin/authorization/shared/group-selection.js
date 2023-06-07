
function toggleActivation(button) {
  if (button.textContent === 'Kích hoạt') {
    button.textContent = 'Hủy kích hoạt';
    button.classList.remove('btn-secondary');
    button.classList.add('btn-primary');
  } else {
    button.textContent = 'Kích hoạt';
    button.classList.remove('btn-primary');
    button.classList.add('btn-secondary');
  }
}

function handleSelectionGroup(groupActives, id, status) {
  if (status !== 'Kích hoạt') {
    groupActives.push(id);
  } else {
    const index = groupActives.indexOf(id);
    if (index > -1) {
      groupActives.splice(index, 1);
    }
  }
}


function bindGroupFormModel(groups, inActiveAll, callback) {
  const tableElement = document.getElementById('authorization-account-group-permission');
  const groupTableBody = tableElement.querySelector('tbody');
  groupTableBody.innerHTML = '';

  const selectedIds = [];

  groups.forEach(group => {
    const row = document.createElement('tr');

    const nameCell = document.createElement('td');
    const nameBadge = document.createElement('span');

    nameBadge.classList.add('badge', 'bg-label-success', 'me-3');
    nameBadge.textContent = group.name;
    nameCell.appendChild(nameBadge);

    row.appendChild(nameCell);

    const descCell = document.createElement('td');
    descCell.textContent = group.desc;
    row.appendChild(descCell);

    const statusCell = document.createElement('td');

    const statusButton = document.createElement('button');
    statusButton.classList.add('btn', 'btn-sm');
    if (inActiveAll) {
        statusButton.textContent = 'Kích hoạt';
        statusButton.classList.add('btn-secondary');
    }
    else if (group.active) {
        statusButton.textContent = 'Hũy Kích hoạt';
        statusButton.classList.add('btn-primary');
        selectedIds.push(group.id);
    }
    else {
        statusButton.textContent = 'Kích hoạt';
        statusButton.classList.add('btn-secondary');
    }

    statusButton.style.width = '120px';
    statusButton.addEventListener('click', () => {
      toggleActivation(statusButton);

      const status = statusButton.textContent;
      handleSelectionGroup(selectedIds, group.id, statusButton.textContent);

      callback(selectedIds);
    });

    statusCell.appendChild(statusButton);
    row.appendChild(statusCell);

    groupTableBody.appendChild(row);
    callback(selectedIds);
  });
}
