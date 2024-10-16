import { useState } from "react";
import { Link } from "react-router-dom";

export default function ProductList(){
    /*
    {id: 1, name: 'Product 1', price: 10.99 },
        {id: 2, name: 'Product 2', price: 9.99 },
        {id: 3, name: 'Product 3', price: 12.99 }
    */
    
    const [list,updateList] = useState([]);    

    const [title,setTitle] = useState("");
    const [price,setPrice] = useState("");


    function saveData(product){
        // update ui
        updateList([...list, product]);

        // call API
        
    }
    
    
    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col">
                <h1>Product List</h1>
            <ul>
                {
                    list.map((p)=>{
                        return <li key={p.id} >
                            <h2>{p.name}</h2>
                            <p>Price: ${p.price}</p>
                            <p>
                                <Link to= { '/products-details/'+p.id }  >more details</Link>
                            </p>
                        </li>
                    })
                }
            </ul>
                </div>
                <div className="col">
                <h1>Add product</h1>

                    <form onSubmit={ (event)=>{
                        event.preventDefault();
                        const product = {id: list.length+1, name:title, price:price};
                        saveData(product);
                    } } >
                    <div className="mb-3">
                            <label htmlFor="">product: </label>
                            <input type="text" 
                            className={ title == '' ? 'form-control is-invalid':'form-control is-valid' }  
                            
                            onChange={ (e)=>{
                                setTitle(e.target.value);
                            } } 
                            
                            value={ title }  />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="">price: </label>
                            <input type="text" 
                            className={ price == '' ? 'form-control is-invalid':'form-control is-valid' }  
                            
                            onChange={ (e)=>{
                                setPrice(e.target.value);
                            } } 
                            
                            value={ price }  />
                        </div>
                        <div>
                            <button className="btn btn-primary w-100" type="submit">Ajouter</button>
                        </div>
                    </form>
                
                </div>
            </div>
        </div>
    );
}