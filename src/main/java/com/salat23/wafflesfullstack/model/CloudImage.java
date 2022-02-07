package com.salat23.wafflesfullstack.model;


import com.cloudinary.utils.ObjectUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@EqualsAndHashCode(callSuper = false)
@Data
public class CloudImage extends BaseEntity {

    private String publicId;
    private String url;
    private String secureUrl;

    public void setData(String publicId, String url, String secureUrl) {
        this.publicId = publicId;
        this.secureUrl = secureUrl;
        this.url = url;
    }

}
