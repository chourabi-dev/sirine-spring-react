import { Link, useParams } from "react-router-dom";

export default function ProductDetails(){
    // read the data from url

    const params = useParams();
    console.log(params);

    return (
        <div>
            <h1>Loading product N° { params.id }</h1>
        </div>
    );
}