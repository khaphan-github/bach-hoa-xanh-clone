package com.bhx.rootcategory;


import com.bhx.shared.SelfValidating;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@Getter
@Setter
@AllArgsConstructor
public class RootCategory extends SelfValidating<RootCategory> implements Serializable {
    @Id
    private String id;

    @NotEmpty(message = "Name must be not empty")
    private String name;

    public RootCategory() {
        // Auto-generated ID with prefix "rc"
        this.id = "rc" + generateNextId();
    }

    private static synchronized int generateNextId() {
        //code get last rc id in database
        String last = "rc1123";

        int lastRCId = extractNumber(last);
        return ++lastRCId;
    }

    //Extract number from RCId
    public static int extractNumber(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }

        return -1; // Return a default value or throw an exception if no number is found
    }
}
