package org.apache.lucene.document;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is where the streaming magic happens. Instead of reading the field's value directly it creates a buffered file reader from the path.
 *
 * Created by jkolb on 5/23/2014.
 */
public class XFilepathField extends Field {

    String fileName;

    public XFilepathField(String name, String value, FieldType fieldType) throws FileNotFoundException {

        super(name, new BufferedReader(new FileReader( value )), fieldType);
        fileName = value;
    }

    @Override
    public TokenStream tokenStream(Analyzer analyzer) throws IOException {
        if (!fieldType().indexed()) {
            return null;
        }

//        public Field(String name, Reader reader, FieldType type) {

        return super.tokenStream(analyzer);
    }
}
