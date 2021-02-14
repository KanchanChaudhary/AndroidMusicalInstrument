package com.kanchan.musicalinstrument.Bll;

import com.kanchan.musicalinstrument.Api.UpdateApi;
import com.kanchan.musicalinstrument.Url.url;


public class UpdateBll {
    UpdateApi Update  = url.getInstance().create(UpdateApi.class);
}
