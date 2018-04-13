package com.appchana.dos.dto;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public class RacquetDTO
{
    private Long racquetId;
    private String mark;
    private String model;
    private String description;
    private String picture01;
    private String picture02;
    private String picture03;

    private RacquetDTO()
    {
    }


    public RacquetDTO(Long racquetId, String mark, String model, String description, String picture01, String picture02, String picture03)
    {
        this.racquetId = racquetId;
        this.mark = mark;
        this.model = model;
        this.description = description;
        this.picture01 = picture01;
        this.picture02 = picture02;
        this.picture03 = picture03;
    }


    public static RacquetDTOBuilder newBuilder()
    {
        return new RacquetDTOBuilder();
    }

    public Long getRacquetId() {
        return racquetId;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture01() {
        return picture01;
    }

    public String getPicture02() {
        return picture02;
    }

    public String getPicture03() {
        return picture03;
    }

    public static class RacquetDTOBuilder
    {
        private Long racquetId;
        private String mark;
        private String model;
        private String description;
        private String picture01;
        private String picture02;
        private String picture03;


        public RacquetDTOBuilder setRacquetId(Long racquetId)
        {
            this.racquetId = racquetId;
            return this;
        }


        public RacquetDTOBuilder setMark(String mark)
        {
            this.mark = mark;
            return this;
        }


        public RacquetDTOBuilder setModel(String model)
        {
            this.model = model;
            return this;
        }


        public RacquetDTOBuilder setDescription(String description)
        {
            this.description = description;
            return this;
        }


        public RacquetDTOBuilder setPicture01(String picture01)
        {
            this.picture01 = picture01;
            return this;
        }


        public RacquetDTOBuilder setPicture02(String picture02)
        {
            this.picture02 = picture02;
            return this;
        }


        public RacquetDTOBuilder setPicture03(String picture03)
        {
            this.picture03 = picture03;
            return this;
        }


        public RacquetDTO createRacquetDTO()
        {
            return new RacquetDTO(racquetId, mark, model, description, picture01, picture02, picture03);
        }

    }
}
