package com.ohgiraffers.fileupload;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileDTO {

    private String originFileName;
    private String saveName;
    private String filePath;
    private String fileDescription;
}
