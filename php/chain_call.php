<?php
class StringHelper
{
    private $value;

    function __construct($value)
    {
        $this->value = $value;
    }

    function __call($function, $args){
        array_unshift($args, $this->value);
        print_r($args);
        $this->value = call_user_func_array($function, $args);
        return $this;
    }


}

$str = new StringHelper("  sd f  0");
echo $str->trim('0')->strlen();
