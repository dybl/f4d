/*
 *
 * File: util.h
 *
 * Created by dyblcjj 陈俊杰 on 02/07/2019
 *
 * email:dyblcjj@163.com
 * 
 * Copyright [2018] [https:github.com/dybl]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
 #include "../recg.h"

namespace lr{
    void GeneralRecognizer::SegmentBasedSequenceRecognition(PlateInfo &plateinfo){
        for(auto char_instance:plateinfo.plateChars)
        {
            std::pair<CharType,cv::Mat> res;
            if(char_instance.second.rows*char_instance.second.cols>40) {
                label code_table = recognizeCharacter(char_instance.second);
                res.first = char_instance.first;
                code_table.copyTo(res.second);
                plateinfo.appendPlateCoding(res);
            } else{
                res.first = INVALID;
                plateinfo.appendPlateCoding(res);
            }
        }
    }
}
