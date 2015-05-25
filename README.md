Quick fiddle with protobuf to verify some behavior involving default values. 
It seems that you can indeed distinguish whether a field has been explicitly set.
However with the default value in play, it's ambigious whether you meant the field is missing (i.e. null)
or you just want to use the default value.
