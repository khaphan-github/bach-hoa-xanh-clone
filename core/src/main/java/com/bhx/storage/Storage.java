package com.bhx.storage;

import com.bhx.shared.SelfValidating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage  extends SelfValidating<Storage> implements Serializable {
    @NotEmpty
    private String id;
    private String address;
    private String name;

}
