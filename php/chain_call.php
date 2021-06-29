<?php
// 如何实现链式调用
//https://segmentfault.com/a/1190000008159324
class ChainCall1
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
    function strlen(){
        return strlen($this->value);
    }

}
class ChainCall2
{
    private $value;

    function __construct($value)
    {
        $this->value = $value;
    }

    function __call($function, $args){
        print_r($args);
        //$this->value = call_user_func($function, $this->value,$args[0]);
        //等同下面这行
        $this->value = $function($this->value,$args[0]); // trim(this->value,"0")
        return $this;
    }

    function strlen(){
        return strlen($this->value);
    }

}

$str = new ChainCall2("  sd f  0");
echo $str->trim('0')->strlen();
