package com.exfaust.testforskyeng

import com.exfaust.testforskyeng.data.model.Meanings
import com.exfaust.testforskyeng.data.model.SearchResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Flowable
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.concurrent.TimeUnit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun fromIterable() {
        val gson = Gson()
        val json:String = "[\n" +
                "  {\n" +
                "    \"id\": 178675,\n" +
                "    \"text\": \"main body\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 253883,\n" +
                "        \"partOfSpeechCode\": \"ph\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"основной текст\",\n" +
                "          \"note\": \"\"\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/a3f09d8e26ba1786e89327e6ac103a5b.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/a3f09d8e26ba1786e89327e6ac103a5b.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"meɪn ˈbɒdi\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=main+body\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 6210,\n" +
                "    \"text\": \"printing\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 69306,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"печатный текст\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/ed4cadaf0328e0382a6ac67ffe866814.gif?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/ed4cadaf0328e0382a6ac67ffe866814.gif?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈprɪntɪŋ\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=printing\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 69307,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"печатное дело\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/456698597700a3a7b4e64955e7723b3a.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/456698597700a3a7b4e64955e7723b3a.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈprɪntɪŋ\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=printing\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 69309,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"тираж\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/993148a547e213109659715f37fc1b75.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/993148a547e213109659715f37fc1b75.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈprɪntɪŋ\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=printing\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 69308,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"печать\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/61ffc180ad4acd463694928936ed3e52.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/61ffc180ad4acd463694928936ed3e52.png?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈprɪntɪŋ\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=printing\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7947,\n" +
                "    \"text\": \"handwriting\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 219943,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"рукописный текст\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/1164674eef1bf0ea0383672fa3e2fbd9.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/1164674eef1bf0ea0383672fa3e2fbd9.png?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈhændˌraɪtɪŋ\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=handwriting\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 219944,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"почерк\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/287abd8966c599bb6827dcf530d0f399.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/287abd8966c599bb6827dcf530d0f399.png?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈhændˌraɪtɪŋ\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=handwriting\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 232247,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"почерк\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/7da5641a5327ffde6bc2527da9c12037.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/7da5641a5327ffde6bc2527da9c12037.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈhændˌraɪtɪŋ\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=handwriting\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 1139,\n" +
                "    \"text\": \"text\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 219584,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"текст\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/99c3545f163686e1c88ba79f07e88639.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/99c3545f163686e1c88ba79f07e88639.png?w=640&h=480\",\n" +
                "        \"transcription\": \"tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=text\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 236500,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"текстовое сообщение\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/dea16ecaf7731d282680c557e4d1a562.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/dea16ecaf7731d282680c557e4d1a562.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=t%C9%9Bkst&transcription=1\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 241813,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"короткий текст\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/adda609ced74a3b759978a1af4db7812.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/adda609ced74a3b759978a1af4db7812.png?w=640&h=480\",\n" +
                "        \"transcription\": \"tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=text\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 219586,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"учебник\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/1173810dc1e74c7fc45c85417b44a3fa.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/1173810dc1e74c7fc45c85417b44a3fa.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=text\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 219585,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"цитата\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/4426eb953ca04a4b918aec529c9d0cea.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/4426eb953ca04a4b918aec529c9d0cea.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=text\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 219587,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"текстовый материал\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/46d5edcca9f8f78c9182953a059c9430.gif?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/46d5edcca9f8f78c9182953a059c9430.gif?w=640&h=480\",\n" +
                "        \"transcription\": \"tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=text\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 239332,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"обязательная литература\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/eceda463d3f565e161bff783a9580785.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/eceda463d3f565e161bff783a9580785.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=text\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 232352,\n" +
                "        \"partOfSpeechCode\": \"v\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"отправлять сообщение\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/ba493de18242a48542362b33bdf7c07c.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/ba493de18242a48542362b33bdf7c07c.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=text\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 113794,\n" +
                "    \"text\": \"textual matter\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 211724,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"текст\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/46d5edcca9f8f78c9182953a059c9430.gif?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/46d5edcca9f8f78c9182953a059c9430.gif?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈtɛkstjʊəl ˈmætə\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=textual+matter\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 9078,\n" +
                "    \"text\": \"scripture\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 106947,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"священный текст\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/c7e6d6b8e31e9204b8aa5d4a8a5c5e9f.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/c7e6d6b8e31e9204b8aa5d4a8a5c5e9f.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈskrɪpʧə\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=scripture\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2841,\n" +
                "    \"text\": \"script\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 224806,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"сценарий\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/ca78c5323e50c9d376bc6c4a7a41942b.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/ca78c5323e50c9d376bc6c4a7a41942b.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"skrɪpt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=script\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 224808,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"письменность\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/30018975383fb00b7181801d4dd324c7.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/30018975383fb00b7181801d4dd324c7.png?w=640&h=480\",\n" +
                "        \"transcription\": \"skrɪpt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=script\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 241676,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"символы языка \",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/5a308efef70ff33765ba9e5b42a948b5.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/5a308efef70ff33765ba9e5b42a948b5.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"skrɪpt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=script\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 224807,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"рукописный текст\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/8293298b1ed94aae649757acb42ae5c1.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/8293298b1ed94aae649757acb42ae5c1.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"skrɪpt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=script\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 231793,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"скрипт\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/dec90022f7917ab17416147c0c5b8b88.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/dec90022f7917ab17416147c0c5b8b88.png?w=640&h=480\",\n" +
                "        \"transcription\": \"skrɪpt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=script\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 224809,\n" +
                "        \"partOfSpeechCode\": \"v\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"писать сценарий\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/b23a4828effa3213d791f575b7053e6a.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/b23a4828effa3213d791f575b7053e6a.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"skrɪpt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=script\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 161042,\n" +
                "    \"text\": \"lyrics\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 236858,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"текст песни\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/b80282f28d280e99121b6f518be57cca.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/b80282f28d280e99121b6f518be57cca.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈlɪrɪks\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=lyrics\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 230321,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"лирические стихи\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/65ab0719c656d305feb1a11438842c26.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/65ab0719c656d305feb1a11438842c26.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈlɪrɪks\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=lyrics\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 80944,\n" +
                "    \"text\": \"sacred text\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 116495,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"религиозный текст\",\n" +
                "          \"note\": \"\"\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/30387e9896f6fba5e1e2105e1506572b.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/30387e9896f6fba5e1e2105e1506572b.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈseɪkrɪd tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=sacred+text\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 178802,\n" +
                "    \"text\": \"skip text\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 254156,\n" +
                "        \"partOfSpeechCode\": \"ph\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"пропускать текст\",\n" +
                "          \"note\": \"\"\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/40f2310ac5e6866a62c087abac96017a.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/40f2310ac5e6866a62c087abac96017a.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"skɪp tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=skip+text\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 180716,\n" +
                "    \"text\": \"structure a text\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 257248,\n" +
                "        \"partOfSpeechCode\": \"ph\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"структурировать текст\",\n" +
                "          \"note\": \"\"\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/a1484e07cb92657125c29930cf0fff87.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/a1484e07cb92657125c29930cf0fff87.png?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈstrʌkʧə ə tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=structure+a+text\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 181765,\n" +
                "    \"text\": \"proofread a text\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 258404,\n" +
                "        \"partOfSpeechCode\": \"ph\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"проверять текст\",\n" +
                "          \"note\": \"\"\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/076508e0bc8e0276c7e0694891ec77b4.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/076508e0bc8e0276c7e0694891ec77b4.png?w=640&h=480\",\n" +
                "        \"transcription\": \"'pruːfriːd ə tekst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=proofread+a+text\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 24951,\n" +
                "    \"text\": \"boilerplate\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 224836,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"котельный лист\",\n" +
                "          \"note\": \"\"\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/ba83293417002cd210f65d3e52980bb6.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/ba83293417002cd210f65d3e52980bb6.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈbɔɪləpleɪt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=boilerplate\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 224835,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"стандартный текст\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/c7e54596c270bd94656d50588e6cc9fd.jpeg?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/c7e54596c270bd94656d50588e6cc9fd.jpeg?w=640&h=480\",\n" +
                "        \"transcription\": \"ˈbɔɪləpleɪt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=boilerplate\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 31079,\n" +
                "    \"text\": \"superscript\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 52165,\n" +
                "        \"partOfSpeechCode\": \"n\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"надстрочный текст\",\n" +
                "          \"note\": \"\"\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/38eb93aea387b7c03fcb058f52631a76.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/38eb93aea387b7c03fcb058f52631a76.png?w=640&h=480\",\n" +
                "        \"transcription\": \"ˌs(j)uːpəˈskrɪpt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=superscript\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 52166,\n" +
                "        \"partOfSpeechCode\": \"j\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"надстрочный\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"\",\n" +
                "        \"imageUrl\": \"\",\n" +
                "        \"transcription\": \"ˌs(j)uːpəˈskrɪpt\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=superscript\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 162435,\n" +
                "    \"text\": \"Read the text.\",\n" +
                "    \"meanings\": [\n" +
                "      {\n" +
                "        \"id\": 230682,\n" +
                "        \"partOfSpeechCode\": \"ph\",\n" +
                "        \"translation\": {\n" +
                "          \"text\": \"Прочтите текст.\",\n" +
                "          \"note\": null\n" +
                "        },\n" +
                "        \"previewUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/1e25795bad3b277f3571bf04fadfaa85.png?w=96&h=72\",\n" +
                "        \"imageUrl\": \"//d2zkmv5t5kao9.cloudfront.net/images/1e25795bad3b277f3571bf04fadfaa85.png?w=640&h=480\",\n" +
                "        \"transcription\": \"riːd ðə tɛkst\",\n" +
                "        \"soundUrl\": \"//d2fmfepycn0xw0.cloudfront.net?gender=male&accent=british&text=Read+the+text.\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]"

        val arrayType = object : TypeToken<List<SearchResult>>() {}.type
        val results: List<SearchResult> = gson.fromJson(json,arrayType)

        assertEquals(
            253883,
            Single.just(results).flatMapPublisher { Flowable.fromIterable(results)}.map { it.meanings }.firstOrError().map { it[0].id }.blockingGet()
        )
        //проверка того, что после toList получаем те же данные (у Flowable этот оператор не работает)
        assertEquals(
            253883,
            Single.just(results).flatMapPublisher{Flowable.fromIterable(results)}.map { it.meanings }.flatMapIterable { it }
                .toList().map { it[0].id }.blockingGet()
        )
    }
}