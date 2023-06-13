package com.bhx.securityconfig.group.delivery.converters;

import com.bhx.global.shared.RestConverter;
import com.bhx.securityconfig.group.Group;
import com.bhx.securityconfig.group.delivery.request.CreateGroupDto;
import org.bson.types.ObjectId;

/**
 * @author "KhaPhan" on 10-Jun-23
 */
public class GroupRestConverter implements RestConverter<CreateGroupDto, Group> {
    @Override
    public Group mapToEntity(final CreateGroupDto viewModel) {
        return new Group(
                new ObjectId().toString(),
                viewModel.getName(),
                viewModel.getDescription(),
                viewModel.isActive()
        );
    }

    @Override
    public CreateGroupDto mapToRest(final Group viewModel) {
        return new CreateGroupDto();
    }
}
