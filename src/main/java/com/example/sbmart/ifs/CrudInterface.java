package com.example.sbmart.ifs;

import com.example.sbmart.model.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);
    <T> Header<Res> read(T t);

/*
    Header<Res> read(Integer no);
    Header<Res> read(String custId); //Customer만 pk가 String Type

 */
    Header<Res> update(Header<Req> request);
   // <T> Header<Res> delete(T t);
    //2022.11.11 변경
    <T> Header delete(T t);
/*
    Header delete(Integer no);
    Header delete(String cusId); //Customer만 pk가 String Type

 */
}
