import { useState } from "react";

// component named Contact
export default function Contact(props){

    

    const [rate,setRate] = useState(props.rate)
    
    

    return(
        <li>
            <p>
              <strong>{ props.name }</strong><br />
              <small>{ props.email }</small> <br/>
              <small>Rating   <button  onClick={ ()=>{ 
                

                /*
                each componenet has an initial state
                never to be changed !!!!
                unless we use some magic power !!!
                useState
                */

                setRate( rate + 1 )
               } }  >{ rate }</button> </small>
            </p>
          </li> 
    );
}